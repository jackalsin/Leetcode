package _1051_1100._1060_Missing_Element_in_Sorted_Array;

/**
 * @author jacka
 * @version 1.0 on 11/10/2020
 */
public final class ONSolution implements Solution {
  @Override
  public int missingElement(int[] nums, int k) {
    final int n = nums.length;
    for (int i = 1; i < n; ++i) {
      final int diff = nums[i] - nums[i - 1] - 1;
      if (diff >= k) {
        return nums[i - 1] + k;
      } else {
        k -= diff;
      }
    }
    return nums[n - 1] + k;
  }
}
