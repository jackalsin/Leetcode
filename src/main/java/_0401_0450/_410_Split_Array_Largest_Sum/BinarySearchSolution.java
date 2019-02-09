package _0401_0450._410_Split_Array_Largest_Sum;

/**
 * @author jacka
 * @version 1.0 on 1/21/2018.
 */
public final class BinarySearchSolution implements Solution {
  public int splitArray(int[] nums, int m) {
    long max = 0, sum = 0;
    for (int n : nums) {
      max = Math.max(n, max);
      sum += n;
    }

    long left = max, right = sum;
    while (left < right) {
      final long mid = left + (right - left) / 2;
      if (isValid(nums, mid) < m) {
        right = mid - 1;
      } else if (isValid(nums, mid) == m) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return (int) left;
  }

  /**
   * Return the count of how many subarray whose sum is less than or equals to mid
   *
   * @param nums
   * @param mid
   * @return
   */
  private static int isValid(final int[] nums, final long mid) {
    int count = 1, curSum = 0;
    for (int i = 0; i < nums.length; i++) {
      curSum += nums[i];
      if (curSum > mid) {
        count++;
        curSum = nums[i];
      }
    }
    return count;
  }
}
