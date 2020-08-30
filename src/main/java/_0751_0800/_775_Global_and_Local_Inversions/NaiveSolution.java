package _0751_0800._775_Global_and_Local_Inversions;

/**
 * @author jacka
 * @version 1.0 on 8/30/2020
 */
public final class NaiveSolution implements Solution {
  @Override
  public boolean isIdealPermutation(int[] A) {
    if (A == null || A.length == 0) {
      return true;
    }
    final int n = A.length;
    for (int i = 0; i < n; ++i) {
      for (int j = i + 1; j < n; ++j) {
        if (A[i] > A[j] && i != j - 1) {
          return false;
        }
      }
    }
    return true;
  }
}
