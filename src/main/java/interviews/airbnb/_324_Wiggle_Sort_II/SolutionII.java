package interviews.airbnb._324_Wiggle_Sort_II;

/**
 * @author jacka
 * @version 1.0 on 2/4/2019.
 */
public final class SolutionII implements Solution {
  private int N;

  public void wiggleSort(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }
    N = nums.length;
    final int midPtr = getKthSmallest(nums, 0, nums.length - 1, (1 + nums.length) / 2),
        midVal = nums[midPtr];
    int left = 0, zhongjian = 0, right = N - 1;

    while (zhongjian <= right) {
      if (nums[newIndex(zhongjian)] > midVal) {
        swap(nums, newIndex(zhongjian), newIndex(left));
        left++;
        zhongjian++;
      } else if (nums[newIndex(zhongjian)] == midVal) {
        zhongjian++;
      } else {
        swap(nums, newIndex(zhongjian), newIndex(right--));
      }
    }
  }

  private static void swap(final int[] nums, final int i, final int j) {
    final int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  private int newIndex(int i) {
    return (2 * i + 1) % (N | 1);
  }

  /**
   * @param nums
   * @param start
   * @param end
   * @param k
   * @return index
   */
  private static int getKthSmallest(final int[] nums, final int start, final int end, final int k) {
    assert start <= end;
    if (start == end) {
      return start;
    }

    final int pivotVal = nums[end];
    int pivotIndex = start, right = end - 1;
    for (int i = start; i < end; i++) {
      if (nums[i] <= pivotVal) {
        swap(nums, i, pivotIndex++);
      }
    }
    swap(nums, end, pivotIndex);
    // pivotIndex 自己及往左都是小于等于
    if (pivotIndex - start + 1 == k) {
      return pivotIndex;
    } else if (pivotIndex - start + 1 < k) {
      return getKthSmallest(nums, pivotIndex + 1, end, k - (pivotIndex - start + 1));
    } else {
      return getKthSmallest(nums, start, pivotIndex - 1, k);
    }
  }
}
