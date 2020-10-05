package facebook._493_Reverse_Pairs;

public final class MergeSortSolution implements Solution {

  public int reversePairs(int[] nums) {
    return reversePairs(nums, 0, nums.length - 1);
  }

  private int reversePairs(final int[] nums, final int left, int right) {
    if (left >= right) {
      return 0;
    }
    final int mid = left + (right - left) / 2;

    int res = reversePairs(nums, left, mid) + reversePairs(nums, mid + 1, right);
    final int[] merged = new int[right - left + 1];
    int i = left, j = mid + 1, k = 0, p = mid + 1;
    while (i <= mid) {
      while (p <= right && nums[i] > 2L * nums[p]) {
        p++;
      }
      res += (p - (mid + 1));

      // merge sort
      while (j <= right && nums[i] >= nums[j]) {
        merged[k++] = nums[j++];
      }
      merged[k++] = nums[i++];
    }
    while (j <= right) {
      merged[k++] = nums[j++];
    }
    assert k == right - left + 1;
    System.arraycopy(merged, 0, nums, left, k);

//    System.out.println(Arrays.toString(merged));
    return res;
  }
}
