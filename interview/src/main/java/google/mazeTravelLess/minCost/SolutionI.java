package google.mazeTravelLess.minCost;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 5/7/2021
 */
public final class SolutionI implements Solution {
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0},
  };

  public int minCost(int[][] maze) {
    final int[] start = {0, 0};
    final Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
    pq.add(new int[]{start[0], start[1], 0});
    final Map<Long, Integer> costs = new HashMap<>() {{
      put(key(start[0], start[1]), 0);
    }};
    final int rows = maze.length, cols = maze[0].length;
    final int[] end = {rows - 1, cols - 1};
    while (!pq.isEmpty()) {
      final int[] toRemove = pq.remove();
      final int x = toRemove[0], y = toRemove[1], cost = toRemove[2];
      if (x == end[0] && y == end[1]) return cost;
      final long key = key(x, y);
      final Integer prevCost = costs.get(key);
      if (prevCost != null && prevCost < cost) continue;
      for (final int[] d : DIRS) {
        final int nextX = d[0] + x, nextY = d[1] + y;
        if (nextX < 0 || nextY < 0 || nextX >= rows || nextY >= cols) continue;
        final long nextKey = key(nextX, nextY);
        final int nextCost = cost + Math.max(0, -maze[x][y] + maze[nextX][nextY]);
        if (costs.getOrDefault(nextKey, Integer.MAX_VALUE) > nextCost) {
          costs.put(nextKey, nextCost);
          pq.add(new int[]{nextX, nextY, nextCost});
        }
      }
    }
    return -1;
  }

  private static long key(final long a, final long b) {
    assert a >= 0 && b >= 0;
    return a << 32 | b;
  }
}
