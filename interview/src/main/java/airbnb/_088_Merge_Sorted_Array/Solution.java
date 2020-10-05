package airbnb._088_Merge_Sorted_Array;

/**
 * @author jacka
 * @version 1.0 on 1/23/2019.
 */
public class Solution {
  public void merge(int[] nums1, final int m, int[] nums2, final int n) {
    int i = m - 1, j = n - 1, resultIndex = n + m - 1;
    while (i >= 0 || j >= 0) {
      if (i >= 0 && j >= 0) {
        if (nums1[i] > nums2[j]) {
          nums1[resultIndex--] = nums1[i];
          i--;
        } else {
          nums1[resultIndex--] = nums2[j];
          j--;
        }
      } else if (i >= 0) {
        nums1[resultIndex--] = nums1[i--];
      } else {
        nums1[resultIndex--] = nums2[j--];
      }
    } // end of while loop

    for (int k = 0; k < m + n - 1; k++) {
      nums1[k] = nums1[++resultIndex];
    }
  }
}
