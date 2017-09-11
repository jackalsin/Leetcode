package _251_300._300_Longest_Increasing_Subsequence;

/**
 * @author jacka
 * @version 1.0 on 9/10/2017.
 */
public class Solution {
  /**
   *
   * @param nums
   * @return
   */
  public int lengthOfLIS(int[] nums) {
//    return oNSquareSolution(nums);
    return oNLogNSolution(nums);
  }

  /**
   * https://discuss.leetcode.com/topic/28738/java-python-binary-search-o-nlogn-time-with-explanation
   *
   * @param nums
   * @return
   */
  private static int oNLogNSolution(int[] nums) {
    final int[] tails = new int[nums.length];
    int max = 0;
    for (int i : nums) {
      int start = 0, end = max;
      while (start < end) {
        int mid = (end - start) / 2 + start;
        if (tails[mid] >= i) {
          end = mid;
        } else {
          start = mid + 1;
        }
      }
      tails[start] = i;
      if (start == max) max++;
    }
    return max;
  }

  private static int oNSquareSolution(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    // longest[i] means the longest increasing sequence ending with longest[i]
    final int[] longest = new int[nums.length];
    longest[0] = 1;
    int max = 1;
    for (int end = 1; end < nums.length; ++end) {
      longest[end] = 1;
      for (int i = 0; i < end; ++i) {
        if (nums[end] > nums[i] && (longest[end] < longest[i] + 1)) {
          longest[end] = longest[i] + 1;
          if (longest[end] > max) {
            max = longest[end];
          }
        }
      }
    }
    return max;
  }

}
