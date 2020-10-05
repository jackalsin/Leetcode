package _0901_0950._922_Sort_Array_By_Parity_II;

/**
 * @author jacka
 * @version 1.0 on 9/19/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] sortArrayByParityII(int[] A) {
    final int n = A.length;
    for (int evenIndex = 0, oddIndex = 1; evenIndex < n; ) {
      while (evenIndex < n && A[evenIndex] % 2 == 0) evenIndex += 2;
      while (oddIndex < n && A[oddIndex] % 2 != 0) oddIndex += 2;
      if (evenIndex < n) {
        assert oddIndex < n;
        swap(A, oddIndex, evenIndex);
      }
    }
    return A;
  }

  private static void swap(final int[] arr, final int i, final int j) {
    final int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
