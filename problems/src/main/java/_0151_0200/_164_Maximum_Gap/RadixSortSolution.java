package _0151_0200._164_Maximum_Gap;

/**
 * @author jacka
 * @version 1.0 on 7/25/2017.
 */
public final class RadixSortSolution implements Solution {
  /**
   * @param nums
   * @return
   */
  public int maximumGap(int[] nums) {
    int maxGap = 0;
    radixSort(nums);
    for (int i = 1; i < nums.length; i++) {
      int gap = nums[i] - nums[i - 1];
      maxGap = maxGap > gap ? maxGap : gap;
    }
    return maxGap;
  }

  /**
   *
   */
  private static final int EXP = 10;

  /**
   * @param nums
   */
  static void radixSort(int[] nums) {
    if (nums.length <= 1) return;
    int max = getMax(nums);
    for (int exp = 1; max / exp > 0; exp *= EXP) {
      countingSort(nums, exp);
    }
  }

  private static void countingSort(int[] nums, int exp) {
    int[] output = new int[nums.length];
    int[] count = new int[EXP];

    for (int i : nums) {
      count[i / exp % EXP]++;
    }

    // move to absolute position
    for (int i = 1; i < count.length; i++) {
      count[i] += count[i - 1];
    }

    for (int i = nums.length - 1; i >= 0; i--) {
      output[count[nums[i] / exp % EXP]-- - 1] = nums[i];
    }
    System.arraycopy(output, 0, nums, 0, nums.length);
  }

  private static int getMax(int[] nums) {
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (max < nums[i]) {
        max = nums[i];
      }
    }
    return max;
  }
}
