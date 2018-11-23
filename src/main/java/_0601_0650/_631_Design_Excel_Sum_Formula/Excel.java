package _0601_0650._631_Design_Excel_Sum_Formula;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 20 / 20 test cases passed.
 * Status: Accepted
 * Runtime: 104 ms
 * @author jacka
 * @version 1.0 on 11/2/2017.
 */
public final class Excel {
  private static final int N = 27;
  private final int[][] values;
  private final Map<Coordinate, Set<Coordinate>> cellToSum;
  private final Map<Coordinate, Map<Coordinate, Integer>> sumToCell;

  public Excel(int H, char W) {
    values = new int[H + 1][W - 'A' + 1];
    cellToSum = new HashMap<>();
    sumToCell = new HashMap<>();
  }

  public void set(int r, char c, int v) {
    final int col = getCol(c);
    final Coordinate sumNode = new Coordinate(r, col);
    if (sumToCell.containsKey(sumNode)) { // no longer a sum, reset
      Set<Coordinate> removed = sumToCell.remove(sumNode).keySet();
      for (Coordinate removedNode: removed) {
        cellToSum.get(removedNode).remove(sumNode);
      }
    }
    updateSum(r, col, v - values[r][col]);
    values[r][col] = v;
  }

  private void updateSum(int row, int col, int delta) {
    final Coordinate curCell = new Coordinate(row, col);
    if (cellToSum.containsKey(curCell)) {
      Set<Coordinate> sumSet = cellToSum.get(curCell); // getOrDefault
      for (Coordinate sum : sumSet) {
        final int times = sumToCell.get(sum).get(curCell);
        values[sum.row][sum.col] += delta * times;
        updateSum(sum.row, sum.col, delta * times); // recursive find the sum cell
      }
    }
  }

  public int get(int r, char c) {
    return values[r][getCol(c)];
  }

  public int sum(int r, char c, String[] strs) {
    int sum = 0;
    final Coordinate sumCell = new Coordinate(r, getCol(c));
    sumToCell.putIfAbsent(sumCell, new HashMap<>());
    final Map<Coordinate, Integer> sumCellMap = sumToCell.get(sumCell);
    for (String coordinator: strs) {
      if (!coordinator.contains(":")) {
        Coordinate coordinate = getCoordinator(coordinator);
        sum += values[coordinate.row][coordinate.col];
        cellToSum.putIfAbsent(coordinate, new HashSet<>());
        cellToSum.get(coordinate).add(sumCell);
        sumCellMap.put(coordinate, sumCellMap.getOrDefault(coordinate, 0) + 1);
      } else {
        String[] coordinatorStrs = coordinator.split(":");
        Coordinate leftTop = getCoordinator(coordinatorStrs[0]);
        Coordinate rightBottom = getCoordinator(coordinatorStrs[1]);
        for (int row = leftTop.row; row <= rightBottom.row; row++) {
          for (int col = leftTop.col; col <= rightBottom.col; col++) {
            final Coordinate curCell = new Coordinate(row, col);
            sum += values[row][col];
            cellToSum.putIfAbsent(curCell , new HashSet<>());
            cellToSum.get(curCell).add(sumCell);
            sumCellMap.put(curCell, sumCellMap.getOrDefault(curCell, 0) + 1);
          }
        }
      }
    }
    values[r][getCol(c)] = sum;
    return sum;
  }

  /**
   * A1 or B2
   * @param coordinator
   * @return
   */
  private Coordinate getCoordinator(String coordinator) {
    final int col = getCol(coordinator.charAt(0));
    final int row = Integer.parseInt(coordinator.substring(1));
    return new Coordinate(row, col);
  }

  private static int getCol(char c) {
    return c - 'A';
  }

  private static final class Coordinate {
    private final int row;
    private final int col;

    Coordinate(int row, int col) {
      this.row = row;
      this.col = col;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Coordinate)) {
        return false;
      }

      Coordinate that = (Coordinate) o;

      return row == that.row && col == that.col;
    }

    @Override
    public int hashCode() {
      int result = row;
      result = 31 * result + col;
      return result;
    }

    @Override
    public String toString() {
      return "Coordinate{" +
          "row=" + row +
          ", col=" + col +
          '}';
    }
  }
}
