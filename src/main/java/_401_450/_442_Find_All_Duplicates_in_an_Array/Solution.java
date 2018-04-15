package _401_450._442_Find_All_Duplicates_in_an_Array;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  /**
   * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
   * <p>
   * Find all the elements that appear twice in this array.
   * <p>
   * Could you do it without extra space and in O(n) runtime?
   * <p>
   * Example:
   * Input:
   * [4,3,2,7,8,2,3,1]
   * <p>
   * Output:
   * [2,3]
   *
   * @param nums
   * @return
   */
  public List<Integer> findDuplicates(int[] nums) {
    final List<Integer> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      int indexToFlip = Math.abs(nums[i]) - 1;
      if (nums[indexToFlip] < 0) {
        final int val = indexToFlip + 1;
        result.add(val);
      }
      nums[indexToFlip] = -nums[indexToFlip];
    }
    return result;
  }
}
