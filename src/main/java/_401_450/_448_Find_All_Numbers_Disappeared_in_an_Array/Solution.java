package _401_450._448_Find_All_Numbers_Disappeared_in_an_Array;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  /**
   * https://discuss.leetcode.com/topic/65738/java-accepted-simple-solution
   *
   * @param nums
   * @return
   */
  public List<Integer> findDisappearedNumbers(int[] nums) {
    final List<Integer> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      int val = Math.abs(nums[i]) - 1;
      if (nums[val] > 0) {
        nums[val] = -nums[val];
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        result.add(i + 1);
      }
    }
    return result;
  }
}
