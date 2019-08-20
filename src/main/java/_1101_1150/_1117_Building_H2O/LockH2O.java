package _1101_1150._1117_Building_H2O;

/**
 * @author jacka
 * @version 1.0 on 8/19/2019
 */
public final class LockH2O implements H2O {
  private volatile int h = 0, o = 0;
  private final Object lock = new Object();

  public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
    synchronized (lock) {
      while (h == 2) {
        lock.wait();
      }
      // releaseHydrogen.run() outputs "H". Do not change or remove this line.
      releaseHydrogen.run();
      ++h;
      resetIfNeed();
      lock.notifyAll();
    }
  }

  public void oxygen(Runnable releaseOxygen) throws InterruptedException {
    synchronized (lock) {
      while (o == 1) {
        lock.wait();
      }
      releaseOxygen.run();
      o++;
      resetIfNeed();
      // releaseOxygen.run() outputs "O". Do not change or remove this line.
      lock.notifyAll();
    }
  }

  private void resetIfNeed() {
    if (h == 2 && o == 1) {
      h = 0;
      o = 0;
    }
  }
}
