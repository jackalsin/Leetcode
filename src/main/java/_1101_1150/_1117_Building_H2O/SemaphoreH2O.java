package _1101_1150._1117_Building_H2O;

import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;

/**
 * @author jacka
 * @version 1.0 on 8/19/2019
 */
public final class SemaphoreH2O implements H2O {
  private final Semaphore h = new Semaphore(2),
      o = new Semaphore(1);
  private final Phaser phaser = new Phaser(3);

  public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
    h.acquire();
    releaseHydrogen.run();
    phaser.arriveAndAwaitAdvance();
    h.release();
  }

  public void oxygen(Runnable releaseOxygen) throws InterruptedException {
    o.acquire();
    releaseOxygen.run();
    phaser.arriveAndAwaitAdvance();
    o.release();
  }
}
