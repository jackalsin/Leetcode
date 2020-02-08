package interviews.hulu._398_Random_Pick_Index;

import java.util.Random;

/**
 * @author jacka
 * @version 1.0 on 2/7/2020
 */
public final class ReservoirSampleSolution implements Solution {
  private final int[] nums;
  private final Random rand = new Random();

  public ReservoirSampleSolution(final int[] nums) {
    this.nums = nums;
  }

  public int pick(int target) {
    int count = 1, res = -1;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (target != num) continue;
      final int toss = rand.nextInt(count);
      if (toss == count - 1) res = i;
      count++;
    }
    return res;
  }
}
