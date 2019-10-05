package interviews.linkedin._1117_Building_H2O;

import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;

public final class H2OI implements H2O {
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
