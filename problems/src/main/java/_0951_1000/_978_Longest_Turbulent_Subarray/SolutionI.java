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
    int oddIsPeak = 1,
        evenIsPeak = 1,
        max = 1;
    for (int i = 1; i < n; ++i) {
      if (i % 2 == 0) {
        if (A[i] < A[i - 1]) {
          oddIsPeak++;
          evenIsPeak = 1;
        } else if (A[i] > A[i - 1]) {
          evenIsPeak++;
          oddIsPeak = 1;
        } else {
          oddIsPeak = evenIsPeak = 1;
        }
      } else { // odd
        if (A[i] > A[i - 1]) {
          oddIsPeak++;
          evenIsPeak = 1;
        } else if (A[i] < A[i - 1]) {
          evenIsPeak++;
          oddIsPeak = 1;
        } else {
          evenIsPeak = oddIsPeak = 1;
        }
      }
      max = Math.max(max, oddIsPeak);
      max = Math.max(max, evenIsPeak);
    }
    return max;
  }
}
