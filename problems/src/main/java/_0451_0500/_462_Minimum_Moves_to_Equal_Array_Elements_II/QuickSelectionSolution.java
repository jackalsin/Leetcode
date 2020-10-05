package _0451_0500._462_Minimum_Moves_to_Equal_Array_Elements_II;


public final class QuickSelectionSolution implements Solution {

  /**
   * 29 / 29 test cases passed.
   * Status: Accepted
   * Runtime: 119 ms
   * <p>
   * Time Complexity: Worst case is O(N^2), but on average, it's O(N)
   *
   * @param nums
   * @return
   */
  @Override
  public int minMoves2(int[] nums) {
    int k = nums.length / 2;
    int target = findKthNum(nums, 0, nums.length - 1, k);
    int result = 0;
    for (int num : nums) {
      result += Math.abs(num - target);
    }
    return result;
  }

  private static int findKthNum(final int[] nums, final int start, final int end, final int k) {
    if (start == end) {
      return nums[start];
    }
    final int pivotIndex = partition(nums, start, end);
    if (pivotIndex == k) {
      return nums[pivotIndex];
    } else if (pivotIndex < k) {
      return findKthNum(nums, pivotIndex + 1, end, k);
    } else { // k > pivotIndex
      return findKthNum(nums, start, pivotIndex - 1, k);
    }
  }

  /**
   * Return such an index <tt>j</tt>, which satisfies that all the elements after <tt>j</tt> are greater than or
   * equals to <tt>nums[j</tt> and all the elements before <tt>j</tt> are smaller than <tt>nums[j]</tt>
   *
   * @param nums
   * @param start
   * @param end
   * @return
   */
  private static int partition(final int[] nums, final int start, final int end) {
    assert (start <= end);
    if (start == end) {
      return start;
    }
    int pivotValue = nums[start];
    int i = start + 1, j = end;
    for (; i <= j; ) {
      while (i <= j && nums[i] < pivotValue) i++;
      while (i <= j && nums[j] >= pivotValue) j--;

      if (i < j) {
        swap(nums, i, j);
        i++;
        j--;
      }
    }
    swap(nums, j, start);
    return j;
  }

  private static void swap(final int[] nums, final int i, final int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
