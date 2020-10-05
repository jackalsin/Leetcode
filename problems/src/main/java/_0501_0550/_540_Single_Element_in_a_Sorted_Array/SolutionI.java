package _0501_0550._540_Single_Element_in_a_Sorted_Array;

/**
 * @author jacka
 * @version 1.0 on 1/28/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int singleNonDuplicate(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    final int len = nums.length;
    int left = 0, right = len - 1;
    while (left < right) {
      final int mid = left + (right - left) / 2;
//      System.out.println("left = " + left + ", right = " + right + ", mid = " + mid);
      if (isOnLeftOrSelf(nums, mid)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return nums[left];
  }

  /**
   * return true if the single element is on it's left or self
   */
  private static boolean isOnLeftOrSelf(final int[] nums, final int i) {
    final int len = nums.length;
    assert 0 <= i && i < len;
    boolean isFirstOccur = i + 1 == len || (i + 1 < len && nums[i] == nums[i + 1]);
    if (isFirstOccur) {
      return i % 2 != 0;
    } else {
      return i % 2 == 0;
    }
  }
}
