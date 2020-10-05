package _0801_0850._832_Flipping_an_Image;

/**
 * @author jacka
 * @version 1.0 on 9/2/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[][] flipAndInvertImage(int[][] A) {
    if (A == null || A.length == 0) {
      return A;
    }
    for (final int[] row : A) {
      final int cols = row.length;
      for (int i = 0, j = cols - 1; i <= j; ++i, --j) {
        swapAndInvert(row, i, j);
      }
    }
    return A;
  }

  private static void swapAndInvert(final int[] row, final int i, final int j) {
    if (i == j) {
      row[i] = 1 - row[i];
    } else {
      final int left = 1 - row[i], right = 1 - row[j];
      row[i] = right;
      row[j] = left;
    }
  }
}
