package _0551_0600._565_Array_Nesting;

/**
 * @author jacka
 * @version 1.0 on 2/2/2020
 */
public final class SolutionI implements Solution {
  /**
   * 根据题意，any value in [0, n -1] 会有一个值指向它，也就是一定会有一个或者多个完整的环
   */
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
