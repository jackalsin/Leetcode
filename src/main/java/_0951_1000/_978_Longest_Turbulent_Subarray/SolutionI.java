package _0951_1000._978_Longest_Turbulent_Subarray;

/**
 * @author zhixi
 * @version 1.0 on 10/4/2020
 */
public final class SolutionI implements Solution {

  @Override
  public int maxTurbulenceSize(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }
    final int n = A.length;
    final int[] oddIsPeak = new int[n],
        evenIsPeak = new int[n];
    oddIsPeak[0] = evenIsPeak[0] = 1;
    int max = 1;
    for (int i = 1; i < n; ++i) {
      if (i % 2 == 0) {
        if (A[i] < A[i - 1]) {
          oddIsPeak[i] = oddIsPeak[i - 1] + 1;
          evenIsPeak[i] = 1;
        } else if (A[i] > A[i - 1]) {
          evenIsPeak[i] = evenIsPeak[i - 1] + 1;
          oddIsPeak[i] = 1;
        } else {
          oddIsPeak[i] = 1;
          evenIsPeak[i] = 1;
        }
      } else { // odd
        if (A[i] > A[i - 1]) {
          oddIsPeak[i] = oddIsPeak[i - 1] + 1;
          evenIsPeak[i] = 1;
        } else if (A[i] < A[i - 1]) {
          evenIsPeak[i] = evenIsPeak[i - 1] + 1;
          oddIsPeak[i] = 1;
        } else {
          evenIsPeak[i] = 1;
          oddIsPeak[i] = 1;
        }
      }
      max = Math.max(max, oddIsPeak[i]);
      max = Math.max(max, evenIsPeak[i]);
    }
    return max;
  }
}
