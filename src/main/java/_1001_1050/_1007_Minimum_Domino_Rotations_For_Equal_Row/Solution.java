package _1001_1050._1007_Minimum_Domino_Rotations_For_Equal_Row;

/**
 * @author jacka
 * @version 1.0 on 3/9/2019.
 */
public final class Solution {
  public int minDominoRotations(int[] A, int[] B) {
    assert A.length >= 1;
    final int countA0 = getCount(A, B, A[0]),
        countB0 = getCount(A, B, B[0]);
    if (countA0 == -1 && countB0 == -1) {
      return -1;
    } else if (countA0 == -1) {
      return countB0;
    } else if (countB0 == -1) {
      return countA0;
    } else {
      return Math.min(countA0, countB0);
    }
  }

  private static int getCount(final int[] a, final int[] b, final int c) {
    int countA = 0, countB = 0;
    for (int i = 0; i < a.length && (a[i] == c || b[i] == c); i++) {
      if (a[i] != c) countA++;
      if (b[i] != c) countB++;
      if (i == a.length - 1) return Math.min(countA, countB);
    }
    return -1;
  }
}
