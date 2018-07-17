package interviews.microsoft._026_Remove_Duplicates_from_Sorted_Array;

public class Solution {
  public int removeDuplicates(int[] nums) {
    int s = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) {
        continue;
      }
      nums[s++] = nums[i];
    }
    return s;
  }
}
