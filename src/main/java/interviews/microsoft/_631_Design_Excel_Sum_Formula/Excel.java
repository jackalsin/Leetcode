package interviews.microsoft._631_Design_Excel_Sum_Formula;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class Excel { // TODO: add time complexity and Set Heavy

  private final int[][] vals;
  /* the cell used by other sum cell */
  private final Map<Point, Set<Point>> cellToSum = new HashMap<>();

  /* Sum Cell to a mapping from childCell to Counts */
  private final Map<Point, Map<Point, Integer>> sumToCell = new HashMap<>();

  public Excel(int H, char W) {
    vals = new int[H + 1][W - 'A' + 1];
  }

  public void set(int r, char c, int v) {
    final int row = r, col = c - 'A';
    final Point curNodc = new Point(row, col);
    if (sumToCell.containsKey(curNodc)) {
      final Set<Point> children = sumToCell.remove(curNodc).keySet();
      for (Point child : children) {
        cellToSum.get(child).remove(curNodc);
      }
    }
    updateSum(curNodc, v - vals[row][col]);
    vals[row][col] = v;
  }

  private void updateSum(final Point node, int diff) {
    if (cellToSum.containsKey(node)) {
      final Set<Point> parents = cellToSum.get(node);
      for (Point parent : parents) {
        final int times = sumToCell.get(parent).get(node);
        vals[parent.x][parent.y] += times * diff;
        updateSum(parent, times * diff); // recursively update
      }
    }
  }

  public int get(int r, char c) {
    return vals[r][c - 'A'];
  }

  public int sum(int r, char c, String[] strs) {
    int sum = 0;
    final int row = r, col = c - 'A';
    final Point sumNode = new Point(row, col);
    sumToCell.putIfAbsent(sumNode, new HashMap<>());
    final Map<Point, Integer> sumToChildMap = sumToCell.get(sumNode);
    for (final String str : strs) {
      final String[] items = str.split(":");
      if (items.length == 1) {
        // A1
        final int curRow = Integer.parseInt(items[0].substring(1)), curCol = items[0].charAt(0) - 'A';
        sum += vals[curRow][curCol];
        establishSumToChild(sumToChildMap, sumNode, new Point(curRow, curCol));
      } else {
        final int startRow = Integer.parseInt(items[0].substring(1)), startCol = items[0].charAt(0) - 'A', endRow =
            Integer.parseInt(items[1].substring(1)), endCol = items[1].charAt(0) - 'A';
        for (int curRow = startRow; curRow <= endRow; curRow++) {
          for (int curCol = startCol; curCol <= endCol; curCol++) {
            sum += vals[curRow][curCol];
            establishSumToChild(sumToChildMap, sumNode, new Point(curRow, curCol));
          }
        }
      }
    }
    vals[row][col] = sum;
    return sum;
  }

  private void establishSumToChild(Map<Point, Integer> sumToChildMap, final Point sumNode, final Point child) {
    cellToSum.putIfAbsent(child, new HashSet<>());
    cellToSum.get(child).add(sumNode);
    sumToChildMap.put(child, sumToChildMap.getOrDefault(child, 0) + 1);
  }

}
