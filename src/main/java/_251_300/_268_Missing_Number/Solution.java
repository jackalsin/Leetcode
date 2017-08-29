package _251_300._268_Missing_Number;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 8/28/2017.
 */
public class Solution {
  public int missingNumber(int[] nums) {
//    return oNSpaceSolution(nums);
    return o1SpaceSolution(nums);
  }

  private int o1SpaceSolution(int[] nums) {
    int result = nums.length;
    for (int i = 0; i < nums.length; ++i) {
      result ^= i;
      result ^= nums[i];
    }
    return result;
  }


  private int oNSpaceSolution(int[] nums) {
    Set<Integer> occured = new HashSet<>();
    for (int i: nums) {
      occured.add(i);
    }
    for (int i = 0; i <= nums.length; ++i) {
      if (!occured.contains(i)) {
        return i;
      }
    }
    throw new IllegalStateException("All elements are contained in " + Arrays.toString(nums));
  }
}
