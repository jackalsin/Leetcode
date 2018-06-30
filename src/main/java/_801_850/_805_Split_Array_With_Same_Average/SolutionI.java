package _801_850._805_Split_Array_With_Same_Average;

import java.util.Arrays;

/**
 * 这个最终还是TLE了，没办法优化了。。。
 */
public final class SolutionI implements Solution {

  /**
   * package _801_850._805_Split_Array_With_Same_AverageExecution Time = 3891.709204ms
   *
   * @param A
   * @return
   */
  public boolean splitArraySameAverage(int[] A) {
    int totalSum = 0, n = A.length, m = A.length / 2;
    for (int num : A) {
      totalSum += num;
    }
    Arrays.sort(A);
    reverse(A);
    for (int k = 1; k <= m; k++) {
      if (totalSum * k % n == 0 && combinationSum(A, k, totalSum * k / n, 0)) {
        return true;
      }
    }
    return false;
  }

  private static boolean combinationSum(int[] a, int size, final int targetSum, final int startIndex) {
    if (size == 0) {
      return targetSum == 0;
    }
    if (targetSum > size * a[startIndex]) {
      return false;
    }
    for (int i = startIndex; i < a.length - size + 1; i++) { // Execution Time = 675.091668ms
      if (targetSum >= a[i] && combinationSum(a, size - 1, targetSum - a[i], i + 1)) {
        return true;
      }
    }

    return false;
  }

  private static void reverse(int[] a) {
    int left = 0, right = a.length - 1;
    while (left < right) {
      final int tmp = a[right];
      a[right] = a[left];
      a[left] = tmp;
      left++;
      right--;
    }
  }
}
