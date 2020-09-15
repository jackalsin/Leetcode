package _0851_0900._885_Spiral_Matrix_III;

/**
 * @author jacka
 * @version 1.0 on 9/14/2020
 */
public final class SolutionI implements Solution {

  private static final int[][] DIRS = {
      {0, 1}, {1, 0}, {0, -1}, {-1, 0}
  };

  private static boolean isInRange(final int rows, final int cols, final int r, final int c) {
    return 0 <= r && r < rows && 0 <= c && c < cols;
  }

  public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
    final int[][] result = new int[R * C][2];
    int k = 0;
    result[k++] = new int[]{r0, c0};
    int dirIndex = 0, distance = 0;
    while (k < R * C) {
      if (dirIndex == 0 || dirIndex == 2) distance++;
      final int[] dir = DIRS[dirIndex];
      for (int i = 0; i < distance; ++i) {
        r0 += dir[0];
        c0 += dir[1];
        if (isInRange(R, C, r0, c0)) {
          result[k++] = new int[]{r0, c0};
        }
      }
      dirIndex = (dirIndex + 1) % 4;
    }
    return result;
  }
}
