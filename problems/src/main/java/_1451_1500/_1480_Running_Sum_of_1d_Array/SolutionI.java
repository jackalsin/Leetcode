package _1451_1500._1480_Running_Sum_of_1d_Array;

/**
 * @author zhixi
 * @version 1.0 on 2/9/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int[] runningSum(int[] nums) {
    final int n = nums.length;
    final int[] result = new int[n];
    System.arraycopy(nums, 0, result, 0, n);
    for (int i = 1; i < n; ++i) {
      result[i] += result[i - 1];
    }
    return result;
  }
}
