package hulu._026_Remove_Duplicates_from_Sorted_Array;

/**
 * @author jacka
 * @version 1.0 on 12/12/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int nextPtr = 0;
    for (int i = 0; i < nums.length; ++i) {
      while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
        ++i;
      }
      nums[nextPtr++] = nums[i];
    }
    return nextPtr;
  }
}
