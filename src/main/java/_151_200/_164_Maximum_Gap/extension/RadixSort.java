package _151_200._164_Maximum_Gap.extension;

/**
 * @author jacka
 * @version 1.0 on 7/25/2017.
 */
public final class RadixSort {

  public static void sort(int[] nums) {
    int max = getMax(nums);

    for(int exp = 1; max / exp > 0; exp *= 10) {
      countSort(nums, exp);
    }
  }

  private static void countSort(int[] nums, int exp) {
    int[] output = new int[nums.length];
    int[] count = new int[10];
    // Store count of occurrences in count[]
    for (int i = 0; i < nums.length; i++)
        count[(nums[i]/exp) % 10]++;

    // Change count[i] so that count[i] now contains
    // actual position of this digit in output[]
    for (int i = 1; i < 10; i++)
        count[i] += count[i - 1];

    // Build the output array
    for (int i = nums.length - 1; i >= 0; i--) {
        output[count[ (nums[i]/exp) % 10 ] - 1] = nums[i];
        count[(nums[i]/exp) % 10]--;
    }

    System.arraycopy(output, 0, nums, 0, nums.length);
  }

  private static int getMax(final int[] nums) {
    assert nums.length != 0;
    int max = nums[0];
    for (int i = 1; i < nums.length; ++i) {
      if (nums[i] > max) {
        max = nums[i];
      }
    }
    return max;
  }
}
