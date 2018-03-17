package interviews.uber._300_Longest_Increasing_Subsequence;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 3/16/2018.
 */
public class NLogNSolution implements Solution { // TODO:
  @Override
  public int lengthOfLIS(int[] nums) {
    //    return example(nums);
    return mySolution(nums);
  }

  public int mySolution(int[] nums) {
    // tails is an array storing the smallest tail of all increasing subsequences with length i+1 in
    // tails[i].
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int[] tails = new int[nums.length];
    tails[0] = nums[0];
    int right = 0;
    for (int k = 1; k < nums.length; k++) {
      int x = nums[k];
      System.out.println(x);
      int i = 0, j = right;
      while (i < j) {
        int m = (j - i + 1) / 2 + i;
        if (nums[m] < x) {
          i = m;
        } else {
          j = m - 1;
        }
      }
      // find the first not smaller than
      tails[i + 1] = Math.max(x, tails[i + 1]);
      if (i == right) {
        right++;
      }
    }
    System.out.println(Arrays.toString(tails));
    return right + 1;
  }

  public int example(int[] nums) {
    int[] tails = new int[nums.length];
    int size = 0;
    for (int x : nums) {
      int i = 0, j = size;
      while (i != j) {
        int m = (i + j) / 2;
        if (tails[m] < x) {
          i = m + 1;
        } else {
          j = m;
        }
      }
      tails[i] = x;
      if (i == size) {
        ++size;
      }
    }
    System.out.println(Arrays.toString(tails));
    return size;
  }
}
