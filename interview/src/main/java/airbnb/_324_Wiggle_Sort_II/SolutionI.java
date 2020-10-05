package airbnb._324_Wiggle_Sort_II;

/**
 * @author jacka
 * @version 1.0 on 2/4/2019.
 */
public final class SolutionI implements Solution {
  public void wiggleSort(int[] nums) {
    if (nums == null || nums.length == 0) return;
    final int medianPtr = getKthSmallest(nums, (1 + nums.length) / 2, 0, nums.length - 1);
    final int midVal = nums[medianPtr], n = nums.length;
    int smallPtr = 0, midPtr = 0, bigPtr = nums.length - 1;
    while (midPtr <= bigPtr) {
      if (nums[newIndex(midPtr, n)] < midVal) {
        swap(nums, newIndex(midPtr, n), newIndex(bigPtr--, n));
      } else if (nums[newIndex(midPtr, n)] > midVal) {
        swap(nums, newIndex(midPtr++, n), newIndex(smallPtr++, n));
      } else {
        midPtr++;
      }
    }
  }

  private static int newIndex(final int i, final int n) {
    return (1 + 2 * i) % (n | 1);
  }

  /**
   * @param nums
   * @param k
   * @param left
   * @param right
   * @return index
   */
  private static int getKthSmallest(final int[] nums, final int k, final int left, final int right) {
//    System.out.println(left + " " + right + " " + k);
    if (left >= right) {
      return left;
    }
    int pivotVal = nums[right], p = left;
    for (int i = left; i < right; i++) {
      if (nums[i] <= pivotVal) {
        swap(nums, i, p);
        p++;
      }
    }
    swap(nums, p, right);
    if (p - left + 1 == k) {
      return p;
    } else if (p - left + 1 < k) {
      return getKthSmallest(nums, k - (p - left + 1), p + 1, right);
    } else {
      return getKthSmallest(nums, k, left, p - 1);
    }
  }

  private static void swap(final int[] nums, int i, int j) {
    final int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
