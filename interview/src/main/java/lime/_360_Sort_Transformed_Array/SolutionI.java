package lime._360_Sort_Transformed_Array;

/**
 * @author jacka
 * @version 1.0 on 4/12/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
    if (nums == null || nums.length == 0) {
      return nums;
    }
    final int n = nums.length;
    final int[] result = new int[n];
    if (a >= 0) {
      for (int i = 0, j = n - 1, k = n - 1; i <= j; --k) {
        final int left = getVal(a, b, c, nums[i]), right = getVal(a, b, c, nums[j]);
        if (left < right) {
          result[k] = right;
          --j;
        } else {
          result[k] = left;
          ++i;
        }
      }
    } else {
      for (int i = 0, j = n - 1, k = 0; i <= j; ++k) {
        final int left = getVal(a, b, c, nums[i]), right = getVal(a, b, c, nums[j]);
        if (left < right) {
          result[k] = left;
          ++i;
        } else {
          result[k] = right;
          --j;
        }
      }
    }
    return result;
  }

  private static int getVal(final int a, final int b, final int c, final int x) {
    return a * x * x + b * x + c;
  }
}
