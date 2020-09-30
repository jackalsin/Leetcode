package _0251_0300._286_Walls_and_Gates;

/**
 * @author jacka
 * @version 1.0 on 9/29/2020
 */
public final class DfsSolution implements Solution {
  @Override
  public void wallsAndGates(int[][] rooms) {
    if (rooms == null || rooms.length == 0) {
      return;
    }
    final int rows = rooms.length, cols = rooms[0].length;
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < cols; ++col) {
        if (rooms[row][col] == 0) {
          dfs(rooms, row, col, 0);
        }
      }
    }
  }

  private static void dfs(final int[][] rooms, final int row, final int col, final int distance) {
    final int rows = rooms.length, cols = rooms[0].length;
    if (row < 0 || row >= rows || col < 0 || col >= cols || rooms[row][col] < distance) return;
    rooms[row][col] = distance;
    dfs(rooms, row + 1, col, distance + 1);
    dfs(rooms, row - 1, col, distance + 1);
    dfs(rooms, row, col + 1, distance + 1);
    dfs(rooms, row, col - 1, distance + 1);
  }
}
