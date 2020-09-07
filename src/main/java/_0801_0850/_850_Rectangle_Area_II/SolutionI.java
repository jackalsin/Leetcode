package _0801_0850._850_Rectangle_Area_II;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 9/6/2020
 */
public final class SolutionI implements Solution {
  private static final int MOD = (int) (1E9 + 7), MAX = 1_000_000_000;

  public int rectangleArea(int[][] rectangles) {
    final int n = rectangles.length;
    final List<Point> data = new ArrayList<>();
    for (final int[] r : rectangles) {
      final int x1 = r[0], y1 = r[1], x2 = r[2], y2 = r[3];
      data.add(new Point(x1, y1, 1));
      data.add(new Point(x1, y2, -1));
      data.add(new Point(x2, y1, -1));
      data.add(new Point(x2, y2, 1));
    }
    data.sort((x, y) -> Integer.compare(x.x, y.x));
    int result = 0, prevX = -1;
    long prevY = 0;
    final TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    for (int i = 0; i < data.size(); i++) {
      final Point p = data.get(i);
      treeMap.put(p.y, treeMap.getOrDefault(p.y, 0) + p.val);
      if (i == data.size() - 1 || data.get(i + 1).x > prevX) {
        if (prevX != -1) {
          result = safeAdd(result, prevY * (p.x - prevX));
        }

        prevY = getY(treeMap);
        prevX = p.x;
      }
    }
    return result;
  }

  private static long getY(TreeMap<Integer, Integer> map) {
    int prev = -1;
    long sum = 0, count = 0;
    for (final var e : map.entrySet()) {
      final int key = e.getKey(), value = e.getValue();
      if (prev != -1 && count > 0) {
        sum += key - prev;
      }
      prev = key;
      count += value;
    }
    return sum;
  }

  private static int safeAdd(final long a, final long b) {
    return (int) ((a + b) % MOD);
  }

  private static final class Point {
    private final int x, y, val;

    private Point(final int x, final int y, final int val) {
      this.x = x;
      this.y = y;
      this.val = val;
    }
  }
}
