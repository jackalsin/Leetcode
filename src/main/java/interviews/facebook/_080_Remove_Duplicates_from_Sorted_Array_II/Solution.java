package interviews.facebook._080_Remove_Duplicates_from_Sorted_Array_II;

public class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int nextPtr = 0;
    for (int i = 0; i < nums.length; ) {
      final int count = getCount(nums, i);
      for (int j = 0; j < Math.min(2, count); j++) {
        nums[nextPtr++] = nums[i];
      }
      i += count;
    }
    return nextPtr;
  }

  private static int getCount(final int[] nums, final int start) {
    int count = 0;
    for (int i = start; i < nums.length; i++) {
      if (nums[i] == nums[start]) {
        count++;
      }
    }
    return count;
  }
}
