package interviews.oracle._324_Wiggle_Sort_II;

/**
 * @author jacka
 * @version 1.0 on 12/1/2019
 */
public final class SolutionI implements Solution {
  @Override
  public void wiggleSort(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }
    final int n = nums.length;
    final int mid = getKthSmallest(nums, (n + 1) / 2, 0, n - 1);
//    System.out.println(mid);
    // dutch flag
    for (int zero = 0, one = 0, two = n - 1; one <= two; ) {
      if (nums[getIndex(n, one)] > mid) { // 大小要交换
        swap(nums, getIndex(n, zero), getIndex(n, one));
        one++;
        zero++;
      } else if (nums[getIndex(n, one)] == mid) {
        one++;
      } else {
        swap(nums, getIndex(n, one), getIndex(n, two));
        two--;
      }
//      System.out.println(Arrays.toString(nums));
    }
  }

  private static int getKthSmallest(final int[] nums, final int k, int left, int right) {
    if (left >= right) {
      return nums[left];
    }
    final int pivotVal = nums[right];
    int pivotIndex = left;
    for (int i = left; i < right; ++i) {
      if (nums[i] <= pivotVal) {
        swap(nums, i, pivotIndex);
        pivotIndex++;
      }
    }
    swap(nums, pivotIndex, right);
    if (pivotIndex - left + 1 == k) {
      return nums[pivotIndex];
    } else if (pivotIndex - left + 1 < k) {
      return getKthSmallest(nums, k - (pivotIndex - left + 1), pivotIndex + 1, right);
    } else {
      return getKthSmallest(nums, k, left, pivotIndex - 1);
    }
  }

  private static void swap(final int[] nums, final int i, final int j) {
    final int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  static int getIndex(final int n, final int i) {
    return (2 * i + 1) % (n | 1);
  }
}
