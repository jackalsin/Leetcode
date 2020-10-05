package hulu._059_Spiral_Matrix_II;

/**
 * @author jacka
 * @version 1.0 on 2/23/2020
 */
public final class SolutionI implements Solution {
  private static final int[][] DIRS = {
      {0, 1}, {1, 0}, {0, -1}, {-1, 0}
  };

  public int[][] generateMatrix(int n) {
    if (n <= 0) {
      return new int[0][];
    }
    final int size = n * n;
    final int[][] result = new int[n][n];
    result[0][0] = 1;
    for (int i = 2, dirIndex = 0, x = 0, y = 0;
         i <= size;
         dirIndex = (1 + dirIndex) % 4) {
      final int dx = DIRS[dirIndex][0], dy = DIRS[dirIndex][1];
      while (isInRange(n, x + dx, y + dy) && result[x + dx][y + dy] == 0) {
        x += dx;
        y += dy;
        result[x][y] = i++;
      }
    }
    return result;
  }

  private static boolean isInRange(final int n, final int x, final int y) {
    return 0 <= x && x < n && 0 <= y && y < n;
  }
}
