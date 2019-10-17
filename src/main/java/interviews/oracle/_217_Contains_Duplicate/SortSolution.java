package interviews.oracle._217_Contains_Duplicate;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 10/16/2019
 */
public final class SortSolution implements Solution {
  @Override
  public boolean containsDuplicate(int[] nums) {
    if (nums == null) {
      return false;
    }
    Arrays.sort(nums);
    for (int i = 1; i < nums.length; ++i) {
      if (nums[i] == nums[i - 1]) {
        return true;
      }
    }
    return false;
  }
}
