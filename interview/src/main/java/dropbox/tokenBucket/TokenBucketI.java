package dropbox.tokenBucket;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jacka
 * @version 1.0 on 5/31/2021
 */
public final class TokenBucketI implements TokenBucket {
  private final int maxCapacity, fillRateInSecond;
  private long lastRefillTime;
  private final ReentrantLock lock = new ReentrantLock();
  private final Condition notFull = lock.newCondition(),
      notEmpty = lock.newCondition();
  private final Queue<Integer> buckets = new ArrayDeque<>();
  private final Random rand = new Random();

  public TokenBucketI(final int maxCapacity, final int fillRateInSecond) {
    this.maxCapacity = maxCapacity;
    this.fillRateInSecond = fillRateInSecond;
    lastRefillTime = System.nanoTime();
  }

  @Override
  public List<Integer> get(int n) throws InterruptedException {
    if (n < 0 || n > maxCapacity)
      throw new IllegalArgumentException("n cannot be negative or greater than max capacity, but now = " + n);
    final List<Integer> result = new ArrayList<>();
    while (result.size() < n) {
      lock.lock();
      try {
        while (buckets.isEmpty()) {
          log("Bucket is empty, now signal nonEmpty");
          notEmpty.await();
        }
        result.add(buckets.remove());
        log("get: " + result);
        notFull.signalAll();
      } finally {
        lock.unlock();
      }
    } // end of while
    return result;
  }

  @Override
  public void run() {
    while (true) {
//      log("[" + TokenBucketI.class.getName() + "]: " );
      try {
        refill();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private void refill() throws InterruptedException {
    lock.lock();
    try {
      while (buckets.size() == maxCapacity) {
        log("Bucket is full.");
        notFull.await();
      }
      final long current = System.nanoTime();
      final int toAdd = Math.min((int) ((current - lastRefillTime) / 1E9 * fillRateInSecond),
          maxCapacity - buckets.size());
      if (toAdd == 0) return;
      log("Bucket tries to fill " + toAdd);
      for (int i = 0; i < toAdd; ++i) buckets.add(rand.nextInt(100) + 1);
      lastRefillTime = current;
      notEmpty.signal();
    } finally {
      lock.unlock();
    }
  }

  private static void log(final String message) {
    System.out.println(Calendar.getInstance().getTime() + ": " + message);
  }
}
