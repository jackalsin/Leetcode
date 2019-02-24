package _1001_1050._1001_Grid_Illumination;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/23/2019.
 */
public class Solution {
  private static final int[][] DIRS = {
      {-1, -1}, {0, -1}, {1, -1},
      {-1, 0}, {0, 0}, {1, 0},
      {-1, 1}, {0, 1}, {1, 1},
  };

  public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
    final Map<Integer, Integer> rows = new HashMap<>(), cols = new HashMap<>(),
        dia = new HashMap<>(), antiDia = new HashMap<>();
    final Map<Cell, Integer> lampsCount = new HashMap<>();

    for (int[] l : lamps) {
      final int row = l[0], col = l[1];
      final Cell cell = new Cell(row, col);
      rows.put(row, rows.getOrDefault(row, 0) + 1);
      cols.put(col, cols.getOrDefault(col, 0) + 1);
      dia.put(row - col, dia.getOrDefault(row - col, 0) + 1);
      antiDia.put(row + col, antiDia.getOrDefault(row + col, 0) + 1);
      lampsCount.put(cell, lampsCount.getOrDefault(cell, 0) + 1);
    }
    final int[] ans = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      final int[] q = queries[i];
      if (q[0] < 0 || q[0] >= N || q[1] < 0 || q[1] >= N) {
        continue;
      }
      if (rows.containsKey(q[0]) || cols.containsKey(q[1])
          || dia.containsKey(q[0] - q[1]) || antiDia.containsKey(q[0] + q[1])) {
        ans[i] = 1;
        for (final int[] d : DIRS) {
          final int row = q[0] + d[0], col = q[1] + d[1];
          final Cell cell = new Cell(row, col);
          if (lampsCount.containsKey(cell)) {
            decreaseAndRemoveIfZero(rows, row);
            decreaseAndRemoveIfZero(cols, col);
            decreaseAndRemoveIfZero(dia, row - col);
            decreaseAndRemoveIfZero(antiDia, row + col);
            decreaseAndRemoveIfZero(lampsCount, cell);
          }
        }
      }
    }
    return ans;
  }

  private void decreaseAndRemoveIfZero(final Map map, Object key) {
    if (!map.containsKey(key)) return;
    map.put(key, (int) map.get(key) - 1);
    if ((int) map.get(key) == 0) {
      map.remove(key);
    }
  }

  private static final class Cell {
    private final int row, col;

    private Cell(int row, int col) {
      this.row = row;
      this.col = col;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Cell cell = (Cell) o;

      if (row != cell.row) return false;
      return col == cell.col;
    }

    @Override
    public int hashCode() {
      int result = row;
      result = 31 * result + col;
      return result;
    }
  }

}
