package _0701_0750._740_Delete_and_Earn;

/**
 * @author jacka
 * @version 1.0 on 5/18/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int deleteAndEarn(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    final int n = nums.length;
    final int[] sums = new int[10001];
    for (int num : nums) {
      sums[num] += num;
    }
    int take = 0, noTake = 0;
    for (int sum : sums) {
      final int prevTake = take, prevNoTake = noTake;
      noTake = Math.max(prevNoTake, prevTake);
      take = prevNoTake + sum;
    }
    return Math.max(take, noTake);
  }
}
