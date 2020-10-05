package uber._528_Random_Pick_with_Weight;

import java.util.Random;
import java.util.TreeMap;

public class Solution {
  private final TreeMap<Integer, Integer> preSum = new TreeMap<>();

  private final int total;

  private final Random rand = new Random();

  public Solution(int[] w) {
    int sum = 0;
    for (int i = 0; i < w.length; i++) {
      sum += w[i];
      preSum.put(sum, i); // less than
    }
    total = sum;
  }

  public int pickIndex() {
    final int i = rand.nextInt(total);
    return preSum.higherEntry(i).getValue();
  }
}
