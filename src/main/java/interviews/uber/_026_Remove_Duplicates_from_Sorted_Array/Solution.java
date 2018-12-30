package interviews.uber._026_Remove_Duplicates_from_Sorted_Array;

public class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int size = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) continue;
      nums[size++] = nums[i];
    }
    return size;
  }

}
