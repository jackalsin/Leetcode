package linkedin._004_Median_of_Two_Sorted_Arrays;

/**
 * @author jacka
 * @version 1.0 on 9/17/2019
 */
public final class SolutionI implements Solution {
  @Override
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    assert nums1 != null && nums2 != null;
    final int lenA = nums1.length, lenB = nums2.length;
    if (lenA > lenB) {
      return findMedianSortedArrays(nums2, nums1);
    }
    int left = 0, right = nums1.length;
    final int len = lenA + lenB, half = (len + 1) / 2;

    // left1 + left2 == right1 + right2
    // left1 + left2 == right1 + right2 + 1
    while (true) {
      assert left <= right;
      final int mid = left + (right - left) / 2,
          left1 = mid, right1 = nums1.length - left1,
          left2 = half - left1, right2 = lenB - left2;
      if (left1 > 0 && nums1[left1 - 1] > nums2[left2]) {
        // too big
        right = mid;
      } else if (left2 > 0 && left1 < lenA && nums2[left2 - 1] > nums1[left1]) {
        // too small
        left = mid + 1;
      } else {
        final int maxLeft;
        if (left1 == 0) {
          maxLeft = nums2[left2 - 1];
        } else if (left2 == 0) {
          maxLeft = nums1[left1 - 1];
        } else {
          maxLeft = Math.max(nums1[left1 - 1], nums2[left2 - 1]);
        } // end of init of max Left
        if (len % 2 == 1) {
          return maxLeft;
        }

        final int maxRight;
        if (left1 == lenA) {
          maxRight = nums2[left2];
        } else if (left2 == lenB) {
          maxRight = nums1[left1];
        } else {
          maxRight = Math.min(nums1[left1], nums2[left2]);
        }
        return ((double) maxLeft + maxRight) / 2d;
      }
    }
  }
}