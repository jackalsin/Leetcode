package _0951_1000._980_Unique_Paths_III;

/**
 * @author jacka
 * @version 1.0 on 9/20/2020
 */
public final class SolutionI implements Solution {
  private static final int[][] DIRS = {
      {1, 0}, {-1, 0}, {0, 1}, {0, -1},
  };
  private int rows, cols;
  private static final int OBSTACLE = -1, START = 1, END = 2, EMPTY = 0;
  private int[][] grid;

  public int uniquePathsIII(int[][] grid) {
    int startRow = -1, startCol = -1, endRow = -1, endCol = -1;
    rows = grid.length;
    cols = grid[0].length;
    this.grid = grid;
    int empty = 0;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        switch (grid[row][col]) {
          case START:
            startRow = row;
            startCol = col;
            break;
          case END:
            endRow = row;
            endCol = col;
            break;
          case EMPTY:
            empty++;
            break;
          case -1:
        }
      }
    }
    assert startRow != -1 && startCol != -1 && endRow != -1 && endCol != -1;
    grid[startRow][startCol] = OBSTACLE;
    return dfs(endRow, endCol, startRow, startCol, empty + 1);
  }

  private int dfs(final int endRow, final int endCol, int startRow, int startCol, final int empty) {
    if (startRow == endRow && startCol == endCol) {
      return empty == 0 ? 1 : 0;
    }
    int result = 0;
    for (final int[] d : DIRS) {
      final int nextRow = d[0] + startRow,
          nextCol = d[1] + startCol;
      if (nextRow < 0 || nextCol < 0 || nextRow >= rows || nextCol >= cols) continue;
      if (grid[nextRow][nextCol] != OBSTACLE) {
        final int old = grid[nextRow][nextCol];
        grid[nextRow][nextCol] = OBSTACLE;
        result += dfs(endRow, endCol, nextRow, nextCol, empty - 1);
        grid[nextRow][nextCol] = old;
      }
    }
    return result;
  }

}
