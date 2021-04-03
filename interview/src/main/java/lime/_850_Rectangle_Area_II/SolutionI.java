package lime._850_Rectangle_Area_II;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 4/2/2021
 */
public final class SolutionI implements Solution {
  private static final int MOD = (int) 1E9 + 7;

  public int rectangleArea(int[][] rectangles) {
    final Map<Integer, List<Point>> xToEdges = new TreeMap<>();
    for (final int[] r : rectangles) {
      final int x1 = r[0], y1 = r[1], x2 = r[2], y2 = r[3];
      xToEdges.computeIfAbsent(x1, k -> new ArrayList<>()).add(new Point(y1, 1));
      xToEdges.computeIfAbsent(x1, k -> new ArrayList<>()).add(new Point(y2, -1));
      xToEdges.computeIfAbsent(x2, k -> new ArrayList<>()).add(new Point(y1, -1));
      xToEdges.computeIfAbsent(x2, k -> new ArrayList<>()).add(new Point(y2, 1));
    }

    final TreeMap<Integer, Integer> yToCount = new TreeMap<>();

    int area = 0, prevX = -1;
    long prevY = 0;
    for (final var entry : xToEdges.entrySet()) {
      final int curX = entry.getKey();
      final List<Point> edges = entry.getValue();
      for (final Point edge : edges) {
        final int c1 = yToCount.getOrDefault(edge.y, 0) + edge.count;
        if (c1 == 0) {
          yToCount.remove(edge.y);
        } else {
          yToCount.put(edge.y, c1);
        }
      } // end of for Edge
      if (prevX != -1) {
        area = safeAdd(area, ((long) (curX - prevX)) * prevY);
      }
      prevY = getY(yToCount);
      prevX = curX;
    }
    return area;
  }

  private static int safeAdd(final long a, final long b) {
    return (int) ((a + b) % MOD);
  }

  private static long getY(final TreeMap<Integer, Integer> yToCount) {
    int prev = -1;
    long sum = 0, count = 0;
    for (final var e : yToCount.entrySet()) {
      final int y = e.getKey(), c = e.getValue();
      if (prev != -1 && count > 0) {
        sum += y - prev;
      }
      count += c;
      prev = y;
    }
    return sum;
  }


  private static final class Point {
    private final int y, count;

    private Point(int y, int count) {
      this.y = y;
      this.count = count;
    }

    @Override
    public String toString() {
      return "Point{" +
          "y=" + y +
          ", count=" + count +
          '}';
    }
  }
}
