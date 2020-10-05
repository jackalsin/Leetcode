package _0751_0800._775_Global_and_Local_Inversions;

/**
 * @author jacka
 * @version 1.0 on 8/30/2020
 */
public final class ONSolution implements Solution {
  @Override
  public boolean isIdealPermutation(int[] A) {
    if (A == null || A.length == 0) {
      return true;
    }
    /*
     * For a value i, you can only put it into i - 1, i, i + 1
     * 1) If we placed it at index 0..1, then one of 0..2 would have to be in the index of 3..5, we call it x. And we
     * also know that max[1] is 3, that means we know for sure that we have a global inversion: 3 is in index 0..1, x
     *  = 0..2 is in index 3..5, and 3 > x, their distance is at least 2.
     * 2) If we place 3 at index 5..8, then there must exist one x in the range of 4..8 such that it's placed now in
     * 0..3. By an analysis similar to the one above, we know that x = 4..8 is in index 0..3, and 3 is in index 5..8.
     * There has to be an at-least-distance-2 inversion.
     */
    final int n = A.length;
    for (int i = 0; i < n; ++i) {
      if (Math.abs(A[i] - i) > 1) return false;
    }
    return true;
  }
}
