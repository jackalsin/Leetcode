package interviews.linkedin._088_Merge_Sorted_Array;

public class Solution {
  /**
   * TODO: Redo
   *
   * @param nums1
   * @param m
   * @param nums2
   * @param n
   */
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    for (int i = m - 1, j = n - 1, k = m + n - 1; k >= 0; k--) {
      if (j < 0 || (i >= 0 && nums1[i] > nums2[j])) {
        nums1[k] = nums1[i];
        i--;
      } else {
        nums1[k] = nums2[j];
        j--;
      }
    }
  }

}
