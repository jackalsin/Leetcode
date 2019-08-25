package interviews.linkedin._088_Merge_Sorted_Array;

/**
 * @author jacka
 * @version 1.0 on 8/25/2019
 */
public final class SolutionI implements Solution {
  @Override
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    if (nums1 == null || m < 0 || n < 0 || nums2 == null) {
      return;
    }
    for (int i = m - 1, j = n - 1, k = m + n - 1; k >= 0; --k) {
      if (i < 0 || (j >= 0 && nums1[i] <= nums2[j])) {
        nums1[k] = nums2[j--];
      } else {
        nums1[k] = nums1[i--];
      }
    }
  }
}
