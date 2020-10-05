package google._801_Minimum_Swaps_To_Make_Sequences_Increasing;

/**
 * @author jacka
 * @version 1.0 on 3/28/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int minSwap(int[] A, int[] B) {
    int swapToIncrease = 1, noSwapToIncrease = 0;
    for (int i = 1; i < A.length; ++i) {
      final int min = Math.min(A[i - 1], B[i - 1]),
          max = Math.max(A[i - 1], B[i - 1]);
      if (A[i] > max && B[i] > max) {
        // 任意交换均可
        final int minSwap = Math.min(swapToIncrease, noSwapToIncrease);
        swapToIncrease = minSwap + 1;
        noSwapToIncrease = minSwap;
      } else if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
        final int prevSwap = swapToIncrease, prevNoSwap = noSwapToIncrease;
        swapToIncrease = prevSwap + 1;
        noSwapToIncrease = prevNoSwap;
      } else /*if (A[i - 1] >= B[i] || B[i - 1] >= A[i])*/ {
        final int prevSwap = swapToIncrease, prevNoSwap = noSwapToIncrease;
        swapToIncrease = prevNoSwap + 1;
        noSwapToIncrease = prevSwap;
      }
//      System.out.printf("i = %d, swapToIncrease = %d, noSwapToIncrease = %d\n", i, swapToIncrease, noSwapToIncrease);
    }
    return Math.min(swapToIncrease, noSwapToIncrease);
  }
}
