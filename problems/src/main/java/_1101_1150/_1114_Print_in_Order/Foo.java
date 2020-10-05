package _1101_1150._1114_Print_in_Order;

import java.util.concurrent.Semaphore;

/**
 * @author zhixi
 * @version 1.0 on 1/2/2020
 */
public class Foo {
  private final Semaphore run2 = new Semaphore(0),
      run3 = new Semaphore(0);

  public void first(Runnable printFirst) throws InterruptedException {

    // printFirst.run() outputs "first". Do not change or remove this line.
    printFirst.run();
    run2.release();
  }

  public void second(Runnable printSecond) throws InterruptedException {
    run2.acquire();
    // printSecond.run() outputs "second". Do not change or remove this line.
    printSecond.run();
    run3.release();
  }

  public void third(Runnable printThird) throws InterruptedException {
    run3.acquire();
    // printThird.run() outputs "third". Do not change or remove this line.
    printThird.run();
  }
}
