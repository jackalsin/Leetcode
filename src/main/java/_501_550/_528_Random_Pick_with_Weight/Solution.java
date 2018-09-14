package _501_550._528_Random_Pick_with_Weight;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/13/18
 */
public final class Solution {
  private final TreeMap<Integer, Integer> treeMap = new TreeMap<>();
  private final int sum;
  private final Random random = new Random();

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
    for (int i = 0; i < w.length; ++i) {
      treeMap.put(sum, i);
      sum += w[i];
    }

    this.sum = sum;
  }

  public int pickIndex() {
    final int key = random.nextInt(sum);
    final Map.Entry<Integer, Integer> entry = treeMap.floorEntry(key);
    return entry.getValue();
  }
}
