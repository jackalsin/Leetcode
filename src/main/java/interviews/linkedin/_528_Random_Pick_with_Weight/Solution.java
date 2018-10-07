package interviews.linkedin._528_Random_Pick_with_Weight;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/13/18
 */
public class Solution {
  private final TreeMap<Integer, Integer> upperToIndex = new TreeMap<>();
  private final Random rand = new Random();
  private int sum;

  public Solution(int[] w) {
    int sum = 0;
    for (int i = 0; i < w.length; ++i) {
      sum += w[i];
      upperToIndex.put(sum, i);
    }
    this.sum = sum;
  }

  public int pickIndex() {
    final int i = rand.nextInt(sum);
    final Map.Entry<Integer, Integer> entry = upperToIndex.higherEntry(i);
    return entry.getValue();
  }
}
