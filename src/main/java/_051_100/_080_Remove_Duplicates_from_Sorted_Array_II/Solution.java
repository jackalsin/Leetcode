package _051_100._080_Remove_Duplicates_from_Sorted_Array_II;

/**
 * @author jacka
 * @version 1.0 on 5/14/2017.
 */
public class Solution {
  public int removeDuplicates(int[] nums) {
    int left = 0;
    int right = 0;
    while (right < nums.length) {
      int count = getCount(nums, right);
      int step = count >= 2 ? 2 : 1;
      while (step-- > 0) {
        nums[left++] = nums[right];
      }
      right += count;
    }
    return left; //check 0;

  }

  int getCount(int[] nums, int rightIndex) {
    int curVal = nums[rightIndex];
    int count = 0;
    while (rightIndex < nums.length && curVal == nums[rightIndex++]) count++;
    return count;
  }
}
