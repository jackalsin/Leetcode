package example.overrideEquals.violateLiskovSubstitutionPrinciple;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jacka
 * @version 1.0 on 6/29/2019
 */
public class CounterPoint extends Point {
  private static final AtomicInteger COUNTER = new AtomicInteger();

  public CounterPoint(int x, int y) {
    super(x, y);
    COUNTER.incrementAndGet();
  }

  public int numberCreated() {
    return COUNTER.get();
  }
}
