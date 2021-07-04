package _1901_1950._1920_Build_Array_from_Permutation;

/**
 * @author jacka
 * @version 1.0 on 9/19/2020
 */
public final class SolutionI implements Solution {

  @Override
  public int[] buildArray(int[] nums) {
    final int n = nums.length;
    final int[] res = new int[n];
    for(int i = 0; i < n; ++i) {
      res[i] = nums[nums[i]];
    }
    return res;
  }
}
