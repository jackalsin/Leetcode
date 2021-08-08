package _1501_1550._1588_Sum_of_All_Odd_Length_Subarrays;

/**
 * @author jacka
 * @version 1.0 on 8/7/2021
 */
public final class ON2Solution implements Solution {
  /**
   * Time Complexity: O(N^2)
   * Space Complexity: O(N)
   */
  @Override
  public int sumOddLengthSubarrays(int[] arr) {
    if (arr == null || arr.length == 0) return 0;
    final int n = arr.length;
    final int[] preSum = new int[n + 1];
    for (int i = 0; i < n; ++i) {
      preSum[i + 1] = preSum[i] + arr[i];
    }
    int sum = 0;
    for (int i = 0; i < n; ++i) {
      for (int l = 1; i + l - 1 < n; l += 2) {
        sum += preSum[i + l] - preSum[i];
      }
    }
    return sum;
  }
}
