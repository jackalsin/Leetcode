package linkedin._004_Median_of_Two_Sorted_Arrays;

public final class SolutionII implements Solution {
  @Override
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
    final int len1 = nums1.length, len2 = nums2.length, len = len1 + len2;
    int left = 0, right = len1, halfLen = (len + 1) / 2;
    while (true) {
      final int mid = left + (right - left) / 2,
          left1 = mid, right1 = len1 - left1,
          left2 = halfLen - left1, right2 = len2 - left2;
      if (left1 > 0 && nums1[left1 - 1] > nums2[left2]) { // too big
        assert left2 < len2;
        right = mid - 1;
      } else if (left1 < len1 && left2 - 1 >= 0 && nums2[left2 - 1] > nums1[left1]) { // too small
        left = mid + 1;
      } else {
        final int maxLeft;
        if (left1 == 0) {
          maxLeft = nums2[left2 - 1];
        } else if (left2 == 0) {
          maxLeft = nums1[left1 - 1];
        } else {
          maxLeft = Math.max(nums1[left1 - 1], nums2[left2 - 1]);
        }
        if (len % 2 != 0) return maxLeft;
        final int minRight;
        if (left1 == len1) {
          minRight = nums2[left2];
        } else if (left2 == len2) {
          minRight = nums1[left1];
        } else {
          minRight = Math.min(nums1[left1], nums2[left2]);
        }
        return ((double) maxLeft + minRight) / 2;
      }
    }
  }
}
