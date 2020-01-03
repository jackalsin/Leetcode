package _1101_1150._1115_Print_FooBar_Alternately;

import java.util.concurrent.Semaphore;

/**
 * @author zhixi
 * @version 1.0 on 1/2/2020
 */
public class FooBar {
  private int n;
  private final Semaphore foo = new Semaphore(1),
      bar = new Semaphore(0);

  public FooBar(int n) {
    this.n = n;
  }

  public void foo(Runnable printFoo) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      foo.acquire();
      printFoo.run();
      bar.release();
    }
  }

  public void bar(Runnable printBar) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      bar.acquire();
      printBar.run();
      foo.release();
    }
  }
}
