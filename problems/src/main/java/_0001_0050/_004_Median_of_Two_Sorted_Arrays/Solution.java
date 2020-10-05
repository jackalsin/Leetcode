package _0001_0050._004_Median_of_Two_Sorted_Arrays;

/**
 * @author jacka
 * @version 1.0 on 2017/1/7.
 */
public class Solution {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1 == null) {
      throw new NullPointerException();
    } else if (nums2 == null) {
      throw new NullPointerException();
    } else {
      if (nums1.length > nums2.length) {
        // swap num1 and nums2
        int[] tmp = nums1;
        nums1 = nums2;
        nums2 = tmp;
      }
      int m = nums1.length, n = nums2.length;
      int iMin = 0, iMax = m;
      while (iMin <= iMax) {
        int i = (iMin + iMax) / 2;
        int j = (m + n + 1) / 2 - i;

        if (i > 0 && nums1[i - 1] > nums2[j]) {
          // i is too big, move left
          iMax = i - 1;
        } else if (i < m && nums2[j - 1] > nums1[i]) {
          iMin = i + 1;
        } else {
          // find the target.
          int leftMax = i == 0 ? nums2[j - 1] :
              j == 0 ? nums1[i - 1] : Math.max(nums1[i - 1], nums2[j - 1]);
          if ((m + n) % 2 == 1) { // move up to here to avoid indexOutOfBoundaryException.
            return leftMax;
          }
          int rightMin = i == m ? nums2[j] :
              j == n ? nums1[i] : Math.min(nums1[i], nums2[j]);
          // only even length
          return (leftMax + rightMin) / 2d;
        }
      }
      throw new IllegalStateException("Don't understand.");
    }
  }
}
