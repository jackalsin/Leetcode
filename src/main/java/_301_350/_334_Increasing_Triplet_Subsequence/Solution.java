package _301_350._334_Increasing_Triplet_Subsequence;

/**
 * @author jacka
 * @version 1.0 on 10/2/2017.
 */
public class Solution {
  public boolean increasingTriplet(int[] nums) {
//    return dpSolution(nums);
    return fasterSolution(nums);
  }

  private boolean fasterSolution(int[] nums) {
    int small = Integer.MAX_VALUE;
    int small2 = Integer.MAX_VALUE;
    for (int num : nums) {
      if (num <= small) {
//        small2 = small; // with this line, it will fail {2, 1, 5, 0, 3}
        small = num;
      } else if (num <= small2) {
        small2 = num;
      } else if (num > small2) {
        return true;
      }
    }

    return false;
  }

  private boolean dpSolution(int[] nums) {
    if (nums == null || nums.length < 3) {
      return false;
    }
    final int[] mins = new int[nums.length];
    int curMin = nums[0];
    for (int i = 1; i < nums.length; ++i) {
      mins[i] = curMin;
      curMin = Math.min(curMin, nums[i]);
    }

    final int[] maxs = new int[nums.length];
    int curMax = nums[nums.length - 1];
    for (int i = nums.length - 2; i >= 0; --i) {
      maxs[i] = curMax;
      curMax = Math.max(curMax, nums[i]);
    }

    for (int i = 1; i < nums.length - 1; ++i) {
      if (mins[i] < nums[i] && nums[i] < maxs[i]) {
        return true;
      }
    }
    return false;
  }
}
