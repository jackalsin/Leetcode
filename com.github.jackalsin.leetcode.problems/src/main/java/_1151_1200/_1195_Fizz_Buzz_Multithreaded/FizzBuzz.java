package _1151_1200._1195_Fizz_Buzz_Multithreaded;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author jacka
 * @version 1.0 on 1/2/2020
 */
public final class FizzBuzz {
  private int n;
  private final Semaphore fizz = new Semaphore(0),
      buzz = new Semaphore(0),
      fizzBuzz = new Semaphore(0),
      counter = new Semaphore(1);

  public FizzBuzz(int n) {
    this.n = n;
  }

  // printFizz.run() outputs "fizz".
  public void fizz(Runnable printFizz) throws InterruptedException {
    for (int i = 3; i <= n; i += 3) {
      fizz.acquire();
      if ((i + 3) % 5 == 0) // skip multiples of 15.
        i += 3;
      printFizz.run();
      counter.release();
    }
  }

  // printBuzz.run() outputs "buzz".
  public void buzz(Runnable printBuzz) throws InterruptedException {
    for (int i = 5; i <= n; i += 5) {
      buzz.acquire();
      if ((i + 5) % 3 == 0) // skip multiples of 15.
        i += 5;
      printBuzz.run();
      counter.release();
    }
  }

  // printFizzBuzz.run() outputs "fizzbuzz".
  public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
    for (int i = 15; i <= n; i += 15) {
      fizzBuzz.acquire();
      printFizzBuzz.run();
      counter.release();
    }
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void number(IntConsumer printNumber) throws InterruptedException {
    for (int i = 1; i <= n; ++i) {
      final int mod3 = i % 3, mod5 = i % 5;
      counter.acquire();
      if (mod3 == 0 && mod5 == 0) {
        fizzBuzz.release();
      } else if (mod3 == 0) {
        fizz.release();
      } else if (mod5 == 0) {
        buzz.release();
      } else {
        printNumber.accept(i);
        counter.release();
      }
    }
  }
}
