package apple._398_Random_Pick_Index;

import java.util.Random;

/**
 * @author jacka
 * @version 1.0 on 2/28/2021
 */
public final class ReservoirSampleSolution implements Solution {
  private final int[] nums;
  private final Random rand = new Random();

  public ReservoirSampleSolution(int[] nums) {
    this.nums = nums;
  }

  public int pick(int target) {
    int count = 0, candidate = -1;
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] == target) {
        count++;
        final int r = rand.nextInt(count);
        if (r == 0) {
          candidate = i;
        }
      }
    }
    return candidate;
  }
}
