package _001_050._031_Next_Permutation;

/**
 * @author jacka
 * @version 1.0 on 1/28/2017.
 */
public class Solution {
  public void nextPermutation(int[] nums) {
    if (nums != null && nums.length != 0) {
      int i = nums.length - 1; // the index starting to decrease
      while (i != 0 && nums[i - 1] >= nums[i]) {
        i--;
      }
      if (i == 0) {
        arrayReverse(nums, 0, nums.length);
      } else {
        int swapIndex = nums.length - 1;  // the index of the element in the array least greater
                                          // than nums[i - 1]
        while (nums[i - 1] >= nums[swapIndex]) {
          swapIndex--;
        }
        int tmp = nums[swapIndex];
        nums[swapIndex] = nums[i - 1];
        nums[i - 1] = tmp;
        arrayReverse(nums, i, nums.length);
      }
    }
  }

  /**
   * Inplace reverse an int array from fromIndex to toIndex;
   * @param nums        an not-null int array.
   * @param fromIndex   start index to reverse (inclusive)
   * @param toIndex     ending index to reverse (exclusive)
   */
  private static void arrayReverse(int[] nums, int fromIndex, int toIndex) {
    int left = fromIndex, right = toIndex - 1;
    while (left < right) {
      int tmp = nums[left];
      nums[left] = nums[right];
      nums[right] = tmp;
      left++; right--;
    }
  }
}
