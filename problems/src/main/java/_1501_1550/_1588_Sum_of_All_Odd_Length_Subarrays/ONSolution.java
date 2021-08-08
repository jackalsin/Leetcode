package _1501_1550._1588_Sum_of_All_Odd_Length_Subarrays;

/**
 * @author jacka
 * @version 1.0 on 8/7/2021
 */
public final class ONSolution implements Solution {
  /**
   * <a href='https://leetcode.com/problems/sum-of-all-odd-length-subarrays/discuss/854184/JavaC%2B%2BPython-O(N)-Time-O(1)-Space' />
   */
  @Override
  public int sumOddLengthSubarrays(int[] arr) {
    if (arr == null || arr.length == 0) return 0;
    int sum = 0;
    final int n = arr.length;
    for (int i = 0; i < n; ++i) {
      sum += ((i + 1) * (n - i) + 1) / 2 * arr[i];
    }
    return sum;
  }
}
