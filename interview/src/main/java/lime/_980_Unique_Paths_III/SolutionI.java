package lime._980_Unique_Paths_III;

import definition.TwoDimensionArray;

/**
 * @author jacka
 * @version 1.0 on 4/5/2021
 */
public final class SolutionI implements Solution {
  private int rows = 0, cols = 0;
  private static final int START = 1, //  represents the starting square.  There is exactly one starting square.
      END = 2, // represents the ending square.  There is exactly one ending square.
      EMPTY = 0, // represents empty squares we can walk over.
      VISITED = -1; // represents obstacles that we cannot walk over.
  private int startRow = -1, startCol = -1, endRow = -1, endCol = -1;
  private int[][] grid;

  public int uniquePathsIII(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    rows = grid.length;
    cols = grid[0].length;
    this.grid = grid;
    int emptyCount = 0;
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < cols; ++j) {
        final int val = grid[i][j];
        if (val == START) {
          startRow = i;
          startCol = j;
        } else if (val == END) {
          endRow = i;
          endCol = j;
        } else if (val == EMPTY) {
          emptyCount++;
        }
      }
    }
    return uniquePathsIII(startRow, startCol, emptyCount);
  }

  private int uniquePathsIII(final int row, final int col, final int emptyCount) {
    if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == VISITED) {
      return 0;
    }
    if (row == endRow && col == endCol) {
      return emptyCount == 0 ? 1 : 0;
    }
    final int oldVal = grid[row][col];
    assert oldVal == EMPTY || oldVal == START;
    grid[row][col] = VISITED;
    final int nextEmpty = oldVal == EMPTY ? emptyCount - 1 : emptyCount;
    int res = uniquePathsIII(row + 1, col, nextEmpty);
    res += uniquePathsIII(row - 1, col, nextEmpty);
    res += uniquePathsIII(row, col + 1, nextEmpty);
    res += uniquePathsIII(row, col - 1, nextEmpty);
    grid[row][col] = oldVal;
    return res;
  }
}
