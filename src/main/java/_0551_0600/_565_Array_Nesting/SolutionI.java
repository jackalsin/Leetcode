package _0551_0600._565_Array_Nesting;

/**
 * @author jacka
 * @version 1.0 on 2/2/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int arrayNesting(int[] nums) {
    int maxSize = 0;
    for (int i = 0; i < nums.length; ++i) {
      int size = 0;
      for (int j = i; nums[j] >= 0; size++) {
        final int next = nums[j];
        nums[j] = -1;
        j = next;
      }
      maxSize = Math.max(maxSize, size);
    }
    return maxSize;
  }
}
