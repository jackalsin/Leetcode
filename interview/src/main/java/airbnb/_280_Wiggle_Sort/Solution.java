package airbnb._280_Wiggle_Sort;

/**
 * @author jacka
 * @version 1.0 on 2/24/2019.
 */
public final class Solution {
  public void wiggleSort(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      if (i % 2 == 1 && nums[i - 1] > nums[i]) {
        swap(nums, i, i - 1);
      } else if (i % 2 == 0 && nums[i] > nums[i - 1]) {
        swap(nums, i, i - 1);
      }
    }
  }

  private static void swap(final int[] array, final int i, final int j) {
    final int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}
