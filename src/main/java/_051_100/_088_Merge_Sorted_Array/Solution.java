package _051_100._088_Merge_Sorted_Array;

/**
 * @author jacka
 * @version 1.0 on 5/28/2017.
 */
public class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;
    int j = n - 1;
    int cur = n + m - 1;
    while (cur>=0) {
      if (i >= 0 && j >= 0) {
        nums1[cur--] = nums1[i] > nums2[j] ? nums1[i--]: nums2[j--];
      } else if (j < 0) {
        break;
      } else { // i < 0
        System.arraycopy(nums2, 0,nums1, 0, cur+ 1);
        break;
      }
    }
  }
}
