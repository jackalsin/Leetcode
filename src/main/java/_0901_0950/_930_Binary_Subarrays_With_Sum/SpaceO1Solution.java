package _0901_0950._930_Binary_Subarrays_With_Sum;

/**
 * @author jacka
 * @version 1.0 on 9/22/2020
 */
public final class SpaceO1Solution implements Solution {
  /**
   * <a href='https://leetcode.com/problems/binary-subarrays-with-sum/discuss/186683/C%2B%2BJavaPython-Sliding-Window-O(1)-Space'></a>
   */
  @Override
  public int numSubarraysWithSum(int[] A, int S) {
    return atMost(A, S) - atMost(A, S - 1);
  }

  /**
   * Returns subarray count whose sum <= {@code target}
   */
  private static int atMost(final int[] arr, final int target) {
    if (target < 0) return 0;
    int result = 0, sum = 0;
    final int n = arr.length;
    for (int l = 0, r = 0; r < n; ++r) {
      sum += arr[r];
      while (sum > target) {
        sum -= arr[l];
        ++l;
      }
      // (r - l + 1) is the count ending here since [l, r] sum is absolutely less than or equals to {@code target}
      result += r - l + 1;
    }
    return result;
  }

}
