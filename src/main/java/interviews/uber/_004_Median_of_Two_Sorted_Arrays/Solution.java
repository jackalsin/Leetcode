package interviews.uber._004_Median_of_Two_Sorted_Arrays;

/**
 * @author jacka
 * @version 1.0 on 3/13/2018.
 */
public class Solution {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
      int[] tmp = nums1;
      nums1 = nums2;
      nums2 = tmp;
    }
    final int m = nums1.length,
        n = nums2.length,
        halfLen = (m + n + 1) / 2; // 9 /2 = 4, should be 5, adding 1
    int iLeft = 0, iRight = m;
    while (iLeft <= iRight) { // consider the equal
      final int iLeftLen = (iRight - iLeft) / 2 + iLeft, jLeftLen = halfLen - iLeftLen;
      if (iLeftLen < m && nums1[iLeftLen] < nums2[jLeftLen - 1]) { // iLeftLen too small
        iLeft = iLeftLen + 1;
      } else if (iLeftLen > 0 && nums1[iLeftLen - 1] > nums2[jLeftLen]) {
        iRight = iLeftLen - 1;
      } else {
        int maxLeft = -1;
        if (iLeftLen == 0) {
          maxLeft = nums2[jLeftLen - 1];
        } else if (jLeftLen == 0) {
          maxLeft = nums1[iLeftLen - 1];
        } else {
          maxLeft = Math.max(nums2[jLeftLen - 1], nums1[iLeftLen - 1]);
        }
        if ((m + n) % 2 == 1) {
          return maxLeft;
        }
        int minRight = -1;
        if (jLeftLen == n) {
          minRight = nums1[iLeftLen];
        } else if (iLeftLen == m) {
          minRight = nums2[jLeftLen];
        } else {
          minRight = Math.min(nums1[iLeftLen], nums2[jLeftLen]);
        }

        return ((double) maxLeft + (double) minRight) / 2;
      }
    }
    throw new IllegalStateException("xxxx");
  }
}
