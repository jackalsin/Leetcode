package linkedin._088_Merge_Sorted_Array;

/**
 * @author jacka
 * @version 1.0 on 8/8/2021
 */
public final class SolutionIII implements Solution {
  @Override
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    for (int k = m + n - 1, i = m - 1, j = n - 1; k >= 0; --k) {
      if (i < 0) {
        nums1[k] = nums2[j--];
      } else if (j < 0) {
        nums1[k] = nums1[i--];
      } else {
        if (nums1[i] < nums2[j]) {
          nums1[k] = nums2[j--];
        } else {
          nums1[k] = nums1[i--];
        }
      }
    }
  }
}
