package facebook.practice.Element_Swapping;

/**
 * @author jacka
 * @version 1.0 on 5/2/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int[] findMinArray(int[] arr, int k) {
    for (int i = 0; i < arr.length && k > 0; ++i) {
      final int minValIndex = getMinValIndex(arr, i, k);
      k -= minValIndex - i;
      shift(arr, i, minValIndex);
    }
    return arr;
  }

  private static void shift(final int[] arr, final int start, final int end) {
    final int num = arr[end];
    for (int i = end - 1; i >= start; --i) {
      arr[i + 1] = arr[i];
    }
    arr[start] = num;
  }

  private static int getMinValIndex(final int[] nums, int start, int k) {
    int minVal = nums[start], minIndex = start;
    for (int i = start + 1; i < nums.length && k > 0; ++i, --k) {
      if (minVal > nums[i]) {
        minVal = nums[i];
        minIndex = i;
      }
    }
    return minIndex;
  }

}
