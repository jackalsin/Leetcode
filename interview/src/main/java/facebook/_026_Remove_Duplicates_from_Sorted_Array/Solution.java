package facebook._026_Remove_Duplicates_from_Sorted_Array;

public class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int nextPtr = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) {
        continue;
      }
      nums[nextPtr++] = nums[i];
    }
    return nextPtr;
  }
}
