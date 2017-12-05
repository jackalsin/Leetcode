package _451_500._493_Reverse_Pairs;

public class MergeSortSolution implements Solution {
  @Override
  public int reversePairs(int[] nums) {
    int res = reversePairs(nums, 0, nums.length - 1);
//    System.out.println(Arrays.toString(nums));
    return res;
  }

  private static int reversePairs(final int[] nums, int start, int end) {
    if (start >= end) {
      return 0;
    }
    int mid = start + (end - start) / 2;
    int res = reversePairs(nums, start, mid) + reversePairs(nums, mid + 1, end);
    final int[] merged = new int[end - start + 1];
    int i = start, j = mid + 1, k = 0, p = mid + 1;
    while (i <= mid) {
      while (p <= end && nums[i] > 2L * nums[p]) p++;
      res += (p - (mid + 1));
      while (j <= end && nums[i] > nums[j]) merged[k++] = nums[j++];
      merged[k++] = nums[i++];
    }
    while (j <= end) merged[k++] = nums[j++];
    System.arraycopy(merged, 0, nums, start, end - start + 1);
    return res;
  }

}
