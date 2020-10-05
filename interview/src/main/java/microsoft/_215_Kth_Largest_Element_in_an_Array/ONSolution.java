package microsoft._215_Kth_Largest_Element_in_an_Array;

public final class ONSolution implements Solution {

  public int findKthLargest(int[] nums, int k) {
    assert 0 < nums.length;
    assert 0 < k && k <= nums.length;

    return quickSelect(nums, 0, nums.length - 1, nums.length - k + 1);
  }

  /**
   * Return the index of kth smallest element
   *
   * @param nums
   * @param left
   * @param right
   * @param k     starting with 1
   * @return
   */
  private int quickSelect(int[] nums, int left, int right, int k) {

//    System.out.println("Left = " + left + " Right = " + right);
//    System.out.println(Arrays.toString(nums));

    final int pivot = partition(nums, left, right); // this returns the absolute index;
    if (pivot - left + 1 == k) {
      return nums[pivot];
    } else if (pivot - left + 1 < k) {
      return quickSelect(nums, pivot + 1, right, k - (pivot - left + 1));
    } else {
      return quickSelect(nums, left, pivot - 1, k);
    }
  }

  private static int partition(int[] nums, int left, int right) {
    final int pivot = nums[right];
    int p = left;
    // partition
    for (int i = left; i < right; i++) {
      if (nums[i] <= pivot) {
        swap(nums, p++, i);
      }
    }
    swap(nums, p, right);
    return p;
  }

  private static void swap(final int[] nums, int j, int i) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
