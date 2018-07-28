package interviews.microsoft._004_Median_of_Two_Sorted_Arrays;

public final class SolutionII implements Solution {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    final int m = nums1.length, n = nums2.length, leftLen = m + (n - m + 1) / 2;
    if (m > n) {
      return findMedianSortedArrays(nums2, nums1);
    }

    int left = 0, right = nums1.length;
    while (left <= right) {
      /* after mid */
      final int i = (right - left) / 2 + left, j = leftLen - i;
      if (i != 0 && nums1[i - 1] > nums2[j]) {
        right = i - 1;
      } else if (i < m && nums2[j - 1] > nums1[i]) {
        left = i + 1;
      } else {
        int maxLeft = 0, minRight = 0;

        if (i == 0) {
          maxLeft = nums2[j - 1];
        } else if (j == 0) {
          maxLeft = nums1[i - 1];
        } else {
          maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
        }

        if ((m + n) % 2 == 1) {
          return maxLeft;
        }

        if (i == m) {
          minRight = nums2[j];
        } else if (j == n) {
          minRight = nums1[i];
        } else {
          minRight = Math.min(nums1[i], nums2[j]);
        }

        return ((double) (maxLeft + minRight)) / 2;
      }
    }
    throw new IllegalStateException("You should be here.");
  }
}
