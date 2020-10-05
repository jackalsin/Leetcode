package _0901_0950._905_Sort_Array_By_Parity;

/**
 * @author jacka
 * @version 1.0 on 9/17/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] sortArrayByParity(int[] A) {
    final int n = A.length;
    for (int i = 0, j = n - 1; i < j; ) {
      while (i < j && A[i] % 2 == 0) i++;
      while (i < j && A[j] % 2 != 0) --j;
      if (i < j) {
        swap(A, i, j);
      }
      ++i;
      --j;
    }
    return A;
  }

  private static void swap(final int[] arr, final int i, final int j) {
    final int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
