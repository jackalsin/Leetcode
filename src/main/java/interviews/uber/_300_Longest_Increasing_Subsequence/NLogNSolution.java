package interviews.uber._300_Longest_Increasing_Subsequence;

/**
 * @author jacka
 * @version 1.0 on 3/16/2018.
 */
public class NLogNSolution implements Solution {

  @Override
  public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    final int[] minTail = new int[nums.length];
    minTail[0] = nums[0];
    int end = 0;
    for (int i = 1; i < nums.length; i++) {
      int num = nums[i], left = 0, right = end;

      // find lower than num;
      while (left < right) {
        final int mid = (right - left + 1) / 2 + left;
        if (num > minTail[mid]) {
          left = mid;
        } else {
          right = mid - 1;
        }
      }

      // all the elements are greater than or equals
      if (minTail[left] >= num) {
        left = -1;
      }

      // minTail[left] < nums[i] <= minTail[left + 1]
      minTail[left + 1] = num;
      if (left == end) { // is appending, rather than updating
        end++;
      }
    }
    return end + 1;
  }

}
