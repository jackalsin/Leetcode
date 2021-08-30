package airbnb._324_Wiggle_Sort_II;

/**
 * @author jacka
 * @version 1.0 on 8/28/2021
 */
public final class SolutionIII implements Solution {
  @Override
  public void wiggleSort(int[] nums) {
    if (nums == null || nums.length == 0) return;
    final int n = nums.length,
        // we need k -> if n == 5, k = 3
        // we need k -> if n == 6, k = 3
        k = (n + 1) / 2; // TODO: which to pick?
    nthElement(nums, 0, n - 1, k);
    final int midVal = nums[k - 1];
    for (int zero = 0, one = 0, two = n - 1; one <= two; ++one) {
      if (nums[index(one, n)] > midVal) {
        swap(nums, index(one, n), index(zero, n));
        zero++;
      } else if (nums[index(one, n)] < midVal) {
        swap(nums, index(one, n), index(two, n));
        two--;
      }
    }
  }

  private static void swap(final int[] nums, final int i, final int j) {
    final int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  private static int nthElement(final int[] nums, final int start, final int end, final int k) {
    if (start == end) {
      return start;
    }
    int p = start, pVal = nums[end];
    for (int i = start; i < end; ++i) {
      if (nums[i] <= pVal) {
        swap(nums, i, p);
        p++;
      }
    }
    swap(nums, p, end);
    final int leftLen = p - start + 1;
    if (leftLen < k) {
      return nthElement(nums, p + 1, end, k - leftLen - 1);
    } else if (leftLen == k) {
      return p;
    } else {
      return nthElement(nums, start, p - 1, k);
    }
  }

  /**
   * This method can do
   * index(0, 8) = 1
   * index(1, 8) = 3
   * index(2, 8) = 5
   * index(3, 8) = 7
   * index(4, 8) = 0
   * index(5, 8) = 2
   * index(6, 8) = 4
   * index(7, 8) = 6
   */
  private static int index(final int i, final int n) {
    return (2 * i + 1) % (n | 1);
  }

}
