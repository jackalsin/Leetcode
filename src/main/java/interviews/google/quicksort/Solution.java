package interviews.google.quicksort;

/**
 * @author jacka
 * @version 1.0 on 1/27/2018.
 */
public class Solution {
  public static void quickSort(final int[] nums) {
    quickSort(nums, 0, nums.length - 1);
  }

  private static void quickSort(final int[] nums, int lo, int hi) {
    if (lo >= hi) {
      return;
    }
    int pivotIndex = partition(nums, lo, hi);
    quickSort(nums, lo, pivotIndex - 1);
    quickSort(nums, pivotIndex + 1, hi);

  }

  private static int partition(final int[] nums, final int low, final int high) {
    int i = low - 1;
    int pivot = nums[high];
    for (int j = low; j <= high - 1; j++) {
      if (nums[j] <= pivot) {
        i++;
        swap(nums, i, j);
      }
    }
    swap(nums, ++i, high);
    return i;
  }

  private static void swap(final int[] nums, int left, int right) {
    int tmp = nums[left];
    nums[left] = nums[right];
    nums[right] = tmp;
  }
}
