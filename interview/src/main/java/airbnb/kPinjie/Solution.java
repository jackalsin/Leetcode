package airbnb.kPinjie;

public interface Solution {
  /**
   * 6. k拼接
   * 题目：给定一个数组和一个数组k，从数组中选择最多k个数组，按原顺序组合，求能够组合的最大数字
   * 输入：一维数组，k
   * 输出：最大数字
   *
   * @param nums
   * @param k
   * @return
   */
  String getBiggestNumWithKSelection(final int[] nums, final int k);
}
