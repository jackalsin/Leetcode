package _0051_0100._080_Remove_Duplicates_from_Sorted_Array_II;

/**
 * @author jacka
 * @version 1.0 on 5/14/2017.
 */
public final class OnePassSolution implements Solution {
  public int removeDuplicates(int[] nums) {
    int nextPtr = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i < 2 || nums[i] != nums[nextPtr - 2]) {
        nums[nextPtr++] = nums[i];
      }
    }
    return nextPtr;
  }
}
