package _1201_1250._1226_The_Dining_Philosophers;

import java.util.concurrent.Semaphore;

/**
 * @author jacka
 * @version 1.0 on 1/3/2020
 */
public final class DiningPhilosophers {

  private static final int N = 5;
  private final Semaphore[] forks = new Semaphore[N];

  {
    for (int i = 0; i < N; ++i) {
      forks[i] = new Semaphore(1);
    }
  }

  // call the run() method of any runnable to execute its code
  public void wantsToEat(int philosopher,
                         Runnable pickLeftFork,
                         Runnable pickRightFork,
                         Runnable eat,
                         Runnable putLeftFork,
                         Runnable putRightFork) throws InterruptedException {
    int left = philosopher, right = (philosopher + 1) % N;
    forks[left].acquire();
    forks[right].acquire();
    pickLeftFork.run();
    pickRightFork.run();
    eat.run();
    putLeftFork.run();
    putRightFork.run();
    forks[left].release();
    forks[right].release();
  }
}
