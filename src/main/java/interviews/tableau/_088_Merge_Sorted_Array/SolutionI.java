package interviews.tableau._088_Merge_Sorted_Array;

/**
 * @author jacka
 * @version 1.0 on 2/13/2020
 */
public final class SolutionI implements Solution {
  @Override
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    for (int i = m - 1, j = n - 1, k = m + n - 1; k >= 0; --k) {
      assert i >= 0 || j >= 0;
      if (i >= 0 && j >= 0) {
        if (nums1[i] < nums2[j]) {
          nums1[k] = nums2[j--];
        } else {
          nums1[k] = nums1[i--];
        }
      } else if (i < 0) {
        nums1[k] = nums2[j--];
      } else {
        nums1[k] = nums1[i--];
      }
    }
  }
}
