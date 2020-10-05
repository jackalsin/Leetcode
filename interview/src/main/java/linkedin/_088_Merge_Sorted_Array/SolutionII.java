package linkedin._088_Merge_Sorted_Array;

/**
 * @author jacka
 * @version 1.0 on 10/4/2019
 */
public final class SolutionII implements Solution {
  @Override
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    for (int k = m + n - 1, i = m - 1, j = n - 1; k >= 0; --k) {
      if (j < 0 || i >= 0 && nums1[i] > nums2[j]) {
        nums1[k] = nums1[i--];
      } else {
        nums1[k] = nums2[j--];
      }
    }
  }
}
