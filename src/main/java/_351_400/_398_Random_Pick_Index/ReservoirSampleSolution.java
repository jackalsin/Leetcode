package _351_400._398_Random_Pick_Index;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author jacka
 * @version 1.0 on 1/11/2018.
 */
public final class ReservoirSampleSolution implements Solution {
  private final int[] nums;
  private final Random random;

  public ReservoirSampleSolution(int[] nums) {
    this.nums = nums;
    random = new Random();
  }

  public int pick(int target) {
    List<Integer> index = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        index.add(i);
      }
    }

    int candidate = index.get(0);

    for (int i = 1; i < index.size(); i++) {
      int n = random.nextInt(i + 1);
      if (n < 1) {
        candidate = index.get(i);
      }
    }
    return candidate;
  }
}
