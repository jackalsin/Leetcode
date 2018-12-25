package _0951_1000._959_Regions_Cut_By_Slashes;

public final class DfsSolution implements Solution {
  private static final int NORTH = 0, WEST = 1, EAST = 2, SOUTH = 3;

  public int regionsBySlashes(String[] grid) {
    final int N = grid.length;
    int color = 0;
    final boolean[][][] visited = new boolean[4][N][N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < 4; k++) {
          if (!visited[k][i][j]) {
            dfs(grid, visited, i, j, k);
            color++;
          }
        }
      }
    }

    return color;
  }

  /**
   * @param grid
   * @param visited
   * @param i
   * @param j
   * @param k       from which direction
   */
  private static void dfs(final String[] grid, final boolean[][][] visited, final int i, final int j, final int k) {
    final int N = grid.length;
    if (i < 0 || j < 0 || i >= N || j >= N || visited[k][i][j] || k >= 4) {
      return;
    }

    final char chr = grid[i].charAt(j);

    if (chr == '\\') {
      if (k == NORTH || k == EAST) {
        visited[NORTH][i][j] = visited[EAST][i][j] = true;
        dfs(grid, visited, i - 1, j, SOUTH);
        dfs(grid, visited, i, j + 1, WEST);
      } else {
        visited[SOUTH][i][j] = visited[WEST][i][j] = true;
        dfs(grid, visited, i + 1, j, NORTH);
        dfs(grid, visited, i, j - 1, EAST);
      }
    } else if (chr == '/') {
      if (k == NORTH || k == WEST) {
        visited[NORTH][i][j] = visited[WEST][i][j] = true;
        dfs(grid, visited, i - 1, j, SOUTH);
        dfs(grid, visited, i, j - 1, EAST);
      } else {
        visited[SOUTH][i][j] = visited[EAST][i][j] = true;
        dfs(grid, visited, i + 1, j, NORTH);
        dfs(grid, visited, i, j + 1, WEST);

      }
    } else {
      assert chr == ' ';
      for (int kk = 0; kk < 4; kk++) {
        visited[kk][i][j] = true;
      }
      dfs(grid, visited, i + 1, j, NORTH);
      dfs(grid, visited, i - 1, j, SOUTH);
      dfs(grid, visited, i, j + 1, WEST);
      dfs(grid, visited, i, j - 1, EAST);
    }
  }
}
