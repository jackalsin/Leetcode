package linkedin._215_Kth_Largest_Element_in_an_Array;

public final class SolutionI implements Solution {
  public int findKthLargest(int[] nums, int k) {
    assert 1 <= k && k <= nums.length;
    return quickSelect(nums, 0, nums.length - 1, k);
  }

  private static int quickSelect(final int[] nums, final int start, final int end, final int k) {
//    System.out.println(Arrays.toString(nums));
//    System.out.println(k);
    assert start <= end;
    if (start == end) {
      return nums[start];
    }

    final int pivot = nums[end];
    int p = start;
    for (int i = start; i < end; ++i) {
      if (nums[i] < pivot) {
        swap(nums, i, p);
        p++;
      }
    }
    swap(nums, p, end);

//    System.out.println("After partition " + Arrays.toString(nums));
//    System.out.println("p = " + p);

    // left side equals or smaller, right greater
    if (end - p + 1 == k) {
      return nums[p];
    } else if (end - p + 1 > k) {
      return quickSelect(nums, p + 1, end, k);
    } else {
      return quickSelect(nums, start, p - 1, k - (end - p + 1));
    }

  }

  private static void swap(final int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
