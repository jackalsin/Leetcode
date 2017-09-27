package _301_350._327_Count_of_Range_Sum;

/**
 * @author jacka
 * @version 1.0 on 9/26/2017.
 */
public interface Solution {
  /**
   * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
   * Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤
   * j), inclusive.

   * Note:
   * A naive algorithm of O(n2) is trivial. You MUST do better than that.

   * Example:
   * Given nums = [-2, 5, -1], lower = -2, upper = 2,
   * Return 3.
   * The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.

   * Credits:
   * Special thanks to @dietpepsi for adding this problem and creating all test cases.
   *
   * @param nums
   * @param lower
   * @param upper
   * @return
   */
  int countRangeSum(int[] nums, int lower, int upper);
}
