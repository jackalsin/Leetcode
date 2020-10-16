package _0951_1000._995_Minimum_Number_of_K_Consecutive_Bit_Flips;

/**
 * @author jacka
 * @version 1.0 on 10/15/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int minKBitFlips(int[] A, int K) {
    if (A == null) {
      return 0;
    }
    final int n = A.length;
    final int[] isFlippedStartHere = new int[n];
    /*
    1) isCurBitFlipped = 1, A[i] = 1, we need to flip again
    2) isCurBitFlipped = 0, A[i] = 0, we need to flip again
    * */
    int res = 0, isCurBitFlipped = 0;

    for (int i = 0; i < n; ++i) {
      if (i >= K) {
        isCurBitFlipped ^= isFlippedStartHere[i - K];
      }
      if (isCurBitFlipped == A[i]) {
        if (i + K > n) {
          return -1;
        }
        isFlippedStartHere[i] = 1;
        isCurBitFlipped ^= 1;
        res++;
      }
    }
    return res;
  }
}
