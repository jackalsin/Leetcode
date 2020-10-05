package linkedin._528_Random_Pick_with_Weight;

import java.util.Random;
import java.util.TreeMap;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/13/18
 */
public final class SolutionII implements Solution {
  private final TreeMap<Integer, Integer> upper = new TreeMap<>();
  private final int sum;
  private final Random rand = new Random();

  public SolutionII(final int[] w) {
    int sum = 0;
    for (int i = 0; i < w.length; i++) {
      sum += w[i];
      upper.put(sum, i);
    }
    this.sum = sum;
  }

  public int pickIndex() {
    final int i = rand.nextInt(sum);
    return upper.higherEntry(i).getValue();
  }
}
