package airbnb._075_Sort_Colors;

/**
 * @author jacka
 * @version 1.0 on 1/24/2019.
 */
public class Solution {
  public void sortColors(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }
    int firstNotZero = 0, firstNotSecond = nums.length - 1;
    // 需要使用等于号，因为i并未经过firstNotSecond, <tt>firstNotSecond</tt>
    for (int i = 0; i <= firstNotSecond; ) {
      if (nums[i] == 0) {
        swap(nums, i, firstNotZero);
        i++;
        firstNotZero++;
      } else if (nums[i] == 1) {
        i++;
      } else {
        // this is a swapping number [0, 1] to position i
        swap(nums, i, firstNotSecond);
        firstNotSecond--;
      }
    }
  }

  private static void swap(final int[] nums, final int i, final int j) {
    final int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
