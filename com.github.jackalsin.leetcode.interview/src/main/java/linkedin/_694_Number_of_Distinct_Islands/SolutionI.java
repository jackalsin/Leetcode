package linkedin._694_Number_of_Distinct_Islands;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 8/18/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int numDistinctIslands(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    final int rows = grid.length, cols = grid[0].length;
    final Set<Set<List<Integer>>> islands = new HashSet<>();
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (grid[row][col] == 0) continue;
        final Set<List<Integer>> island = new HashSet<>();
        dfs(island, grid, row, col, row, col);
        if (!island.isEmpty()) {
          islands.add(island);
        }
      }
    }
    return islands.size();
  }

  private static void dfs(final Set<List<Integer>> islands, final int[][] grid,
                          final int startRow, final int startCol, final int row, final int col) {
    final int rows = grid.length, cols = grid[0].length;
    if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0) {
      return;
    }
    islands.add(getCoordination(row - startRow, col - startCol));
    assert grid[row][col] == 1;
    grid[row][col] = 0;
    dfs(islands, grid, startRow, startCol, row + 1, col);
    dfs(islands, grid, startRow, startCol, row - 1, col);
    dfs(islands, grid, startRow, startCol, row, col - 1);
    dfs(islands, grid, startRow, startCol, row, col + 1);
  }

  /**
   * 不可以用这个，因为会导致负数会导致运算错误，
   * assertNotEquals(0b0000_0000_0000_1000_0000_0000_0000_0010, SolutionI.getVal(8, -2));
   *
   * @param i
   * @param j
   * @return
   */
  static long getVal(final int i, final int j) {
    return (((long) i) << 32) | j;
  }

  private static List<Integer> getCoordination(final int i, final int j) {
    return Arrays.asList(i, j);
  }
}
