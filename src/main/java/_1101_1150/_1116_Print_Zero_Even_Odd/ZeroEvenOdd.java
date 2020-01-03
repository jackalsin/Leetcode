package _1101_1150._1116_Print_Zero_Even_Odd;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author zhixi
 * @version 1.0 on 1/2/2020
 */
public class ZeroEvenOdd {
  private int n;
  private final Semaphore zeroPass = new Semaphore(1),
      onePass = new Semaphore(0),
      twoPass = new Semaphore(0);

  public ZeroEvenOdd(int n) {
    this.n = n;
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void zero(IntConsumer printNumber) throws InterruptedException {
    for (int i = 0; i < n; ++i) {
      zeroPass.acquire();
//      System.out.println("Zero: Before 0");
      printNumber.accept(0);
//      System.out.println("Zero: After 0");
      if (i % 2 == 0) {
        onePass.release();
      } else {
        twoPass.release();
      }
    }
  }

  public void even(IntConsumer printNumber) throws InterruptedException {
    for (int count = 2; count <= n; count += 2) {
      twoPass.acquire();
//      System.out.println("Even: Before " + count);
      printNumber.accept(count);
//      System.out.println("Even: After " + count);
      zeroPass.release();
//      System.out.println("Even: zeroPass.availablePermits() = " + zeroPass.availablePermits());
    }
  }

  public void odd(IntConsumer printNumber) throws InterruptedException {
    for (int count = 1; count <= n; count += 2) {
      onePass.acquire();
//      System.out.println("Odd: Before " + count);
      printNumber.accept(count);
//      System.out.println("Odd: After " + count);
      zeroPass.release();
//      System.out.println("Odd: zeroPass.availablePermits() = " + zeroPass.availablePermits());
    }
  }
}
