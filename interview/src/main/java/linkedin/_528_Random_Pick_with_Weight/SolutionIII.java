package linkedin._528_Random_Pick_with_Weight;

import java.util.Random;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 7/25/2019
 */
public final class SolutionIII implements Solution {
  // < x, return i
  private final TreeMap<Long, Integer> sumToIndex = new TreeMap<>();
  private final long sum;
  private final Random rand = new Random();

  public SolutionIII(final int[] w) {
    long sum = 0;
    for (int i = 0; i < w.length; i++) {
      final int num = w[i];
      sum += num;
      sumToIndex.put(sum, i);
    }
    this.sum = sum;
  }

  public int pickIndex() {
    final long r = (long) (rand.nextDouble() * sum);
    return sumToIndex.higherEntry(r).getValue();
  }
}
