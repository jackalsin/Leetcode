package _0501_0550._528_Random_Pick_with_Weight;

import java.util.Random;
import java.util.TreeMap;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/13/18
 */
public final class Solution {
  private final int sum;
  private final Random rand = new Random();
  private final TreeMap<Integer, Integer> treemap = new TreeMap<>();

  /**
   * 1 <= w.length <= 10000
   * 1 <= w[i] <= 10^5
   * pickIndex will be called at most 10000 times.
   * f
   *
   * @param w
   */
  public Solution(int[] w) {
    int sum = 0;
    for (int i = 0; i < w.length; i++) {
      sum += w[i];
      treemap.put(sum, i);
    }
    this.sum = sum;
  }

  public int pickIndex() {
    return treemap.higherEntry(rand.nextInt(sum)).getValue();
  }
}
