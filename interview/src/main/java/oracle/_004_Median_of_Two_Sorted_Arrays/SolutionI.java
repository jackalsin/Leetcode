package oracle._004_Median_of_Two_Sorted_Arrays;

/**
 * @author jacka
 * @version 1.0 on 10/22/2019
 */
public final class SolutionI implements Solution {
  @Override
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    assert nums1 != null && nums2 != null;
    final int m = nums1.length, n = nums2.length, halfLen = (int) (((long) m + n + 1) / 2);
    if (m > n) {
      return findMedianSortedArrays(nums2, nums1);
    }
    int left = 0, right = m;
    while (left <= right) {
      final int i = left + (right - left) / 2,
          j = halfLen - i;
      if (i > 0 && nums1[i - 1] > nums2[j]) { // i is too big
        right = i - 1;
      } else if (i < m && nums2[j - 1] > nums1[i]) {
        left = i + 1;
      } else {
        int maxOfLeft;
        if (i == 0) {
          maxOfLeft = nums2[halfLen - 1];
        } else if (j == 0) {
          maxOfLeft = nums1[halfLen - 1];
        } else {
          maxOfLeft = Math.max(nums1[i - 1], nums2[j - 1]);
        }

        if (((long) m + n) % 2 == 1) {
          return maxOfLeft;
        }

        int minOfRight;
        if (i == m) {
          minOfRight = nums2[j];
        } else if (j == n) {
          minOfRight = nums1[i];
        } else {
          minOfRight = Math.min(nums1[i], nums2[j]);
        }
        return ((double) minOfRight + maxOfLeft) / 2;
      }
    }
    throw new IllegalStateException("You should not come here");
  }
}
