package _001_100._004_Median_of_Two_Sorted_Arrays;

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
      int iMin = 0, iMax = m - 1;
      while (iMin <= iMax) {
        int i = (iMin + iMax) / 2;
        int j = (m + n) / 2 - i;
        if (nums1[i - 1] <= nums2[j] && nums1[j - 1] <= nums2[i]) {
          // find the target.
          int leftMax = Math.max(nums1[i - 1], nums2[j - 1]);
          int rightMin = Math.min(nums1[i], nums2[j]);

          if ((m + n) % 2 == 1) {
            return leftMax;
          } else {
            return (leftMax + rightMin) / 2d;
          }
        } else if (nums1[i - 1] > nums2[j]) { // i is too big, move left
          iMax = i - 1;
        } else if (nums1[j - 1] > nums2[i]) {
          iMin = i;
        } else {
          throw new IllegalStateException("nums1[i - 1] <= nums2[j] && nums1[j - 1] <= nums2[i]: " +
              "i = " + i + " j = " + j + " ");
        }
      }
      throw new IllegalStateException("Don't understand.");
    }
  }
}
