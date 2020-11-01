package _1051_1100._1053_Previous_Permutation_With_One_Swap;

/**
 * @author jacka
 * @version 1.0 on 10/31/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] prevPermOpt1(int[] A) {
    final int n = A.length;
    int start = n - 2;
    for (; start >= 0; --start) {
      if (A[start] > A[start + 1]) {
        break;
      }
    }
    if (start == -1) {
      return A;
    }
    for (int i = n - 1; i > start; --i) {
      if (A[i] < A[start] && A[i] != A[i - 1]) {
        swap(A, start, i);
        break;
      }
    }
    return A;
  }

  private static void swap(final int[] vals, final int i, final int j) {
    final int tmp = vals[i];
    vals[i] = vals[j];
    vals[j] = tmp;
  }
}
