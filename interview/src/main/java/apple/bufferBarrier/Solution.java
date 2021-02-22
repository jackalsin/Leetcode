package apple.bufferBarrier;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;

/**
 * @author jacka
 * @version 1.0 on 2/21/2021
 */
public final class Solution {
  private static final int N = 4;
  private final Phaser phase = new Phaser(N);
  private final ExecutorService executorService =
      Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);

  private void run() {
    for (int i = 0; i < N; ++i) {
      executorService.execute(() -> {
        final Worker worker = new Worker(phase);
        worker.blockSending();
      });
    }
    System.out.println("Run finishes.");
  }

  public static void main(final String[] args) {
    final Solution solution = new Solution();
    solution.run();
  }

  private static final class Worker {
    private final Phaser phase;
    private final Semaphore sendSemaphore = new Semaphore(1);

    private Worker(final Phaser phaser) {
      this.phase = phaser;
    }

    public void blockSending() {
      try {
        sendSemaphore.acquire();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Waiting for reaching over barrier.");
      phase.arriveAndAwaitAdvance();
      System.out.println("Sending.");
      sendSemaphore.release();
    }

  } // end of worker class

}
