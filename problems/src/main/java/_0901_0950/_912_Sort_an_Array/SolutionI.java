package _0901_0950._912_Sort_an_Array;

/**
 * @author jacka
 * @version 1.0 on 9/19/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] sortArray(int[] nums) {
    final int n = nums.length;
    mergeSort(nums, 0, n - 1);
    return nums;
  }

  private static void mergeSort(final int[] nums, final int left, final int right) {
    if (left >= right) return;
    final int mid = left + (right - left) / 2;
    mergeSort(nums, left, mid);
    mergeSort(nums, mid + 1, right);
    final int n = right - left + 1;
    final int[] tmp = new int[right - left + 1];
    for (int i = left, j = mid + 1, k = 0; k < n; ++k) {
      if (j > right || i <= mid && nums[i] < nums[j]) {
        tmp[k] = nums[i];
        ++i;
      } else {
        tmp[k] = nums[j];
        ++j;
      }
    }
    System.arraycopy(tmp, 0, nums, left, n);
  }
}
