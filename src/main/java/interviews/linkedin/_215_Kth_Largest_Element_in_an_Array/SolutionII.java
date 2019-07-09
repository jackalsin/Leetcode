package interviews.linkedin._215_Kth_Largest_Element_in_an_Array;

public final class SolutionII implements Solution {
  @Override
  public int findKthLargest(int[] nums, int k) {
    if (nums == null || k <= 0 || k > nums.length) {
      return -1; // leetcode guarantees
    }
    final int index = findKthLargest(nums, k, 0, nums.length - 1);
    return nums[index];
  }

  private static int findKthLargest(final int[] nums, final int k, final int start, final int end) {
    if (end < start) {
      throw new IllegalStateException();
    } else if (end == start) {
      return start;
    }


    final int pivotVal = nums[end];
    int pivotIndex = start;
    for (int i = start; i < end; i++) {
      if (nums[i] <= pivotVal) {
        swap(nums, i, pivotIndex);
        pivotIndex++;
      }
    }
    swap(nums, pivotIndex, end);
    if (end - pivotIndex + 1 == k) {
      return pivotIndex;
    } else if (end - pivotIndex + 1 < k) {
      return findKthLargest(nums, k - (end - pivotIndex + 1), start, pivotIndex - 1);
    } else {
      return findKthLargest(nums, k, pivotIndex + 1, end);
    }
  }

  private static void swap(final int[] nums, final int i, final int j) {
    final int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

}
