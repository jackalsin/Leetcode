package linkedin._528_Random_Pick_with_Weight;

import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author jacka
 * @version 1.0 on 9/9/2019
 */
public final class SolutionIV implements Solution {
  private final TreeMap<Long, Integer> treeMap = new TreeMap<>();
  private final long sum;

  public SolutionIV(final int[] w) {
    if (w == null) {
      throw new NullPointerException();
    }
    long sum = 0;
    for (int i = 0; i < w.length; i++) {
      treeMap.put(sum, i);
      sum += w[i];
    }
    this.sum = sum;
  }

  public int pickIndex() {
    final long weight = ThreadLocalRandom.current().nextLong(sum);
    return treeMap.floorEntry(weight).getValue();
  }
}
