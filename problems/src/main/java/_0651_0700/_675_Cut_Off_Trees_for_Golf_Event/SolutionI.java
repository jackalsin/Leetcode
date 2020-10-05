package _0651_0700._675_Cut_Off_Trees_for_Golf_Event;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 3/11/2020
 */
public final class SolutionI implements Solution {
  private static final int[][] DIRS = {
      {0, 1}, {0, -1}, {1, 0}, {-1, 0}
  };

  public int cutOffTree(List<List<Integer>> forest) {
    if (forest.get(0).get(0) == 0) {
      return -1;
    }
    int[] cur = {0, 0};
    final List<Integer> targets = getTarget(forest);
//    System.out.println(targets);
//    System.out.println(valToPos);
    int step = 0;
    final int rows = forest.size(), cols = forest.get(0).size();
    final int[][] visited = new int[rows][cols];
    for (int target : targets) {
      visited[cur[0]][cur[1]] = target;
      if (target == forest.get(cur[0]).get(cur[1])) {
        continue;
      }
      final Queue<int[]> q = new ArrayDeque<>();
      q.add(cur);
      boolean found = false;
      qEnd:
      while (!q.isEmpty()) {
        step++;
        final int size = q.size();
        for (int i = 0; i < size; ++i) {
          final int[] toRemove = q.remove();
          for (final int[] d : DIRS) {
            final int nextRow = d[0] + toRemove[0], nextCol = d[1] + toRemove[1];
            if (isInRange(rows, cols, nextRow, nextCol)) {
              final int nextVal = forest.get(nextRow).get(nextCol);
              if (nextVal == target) {
                cur = new int[]{nextRow, nextCol};
                found = true;
                break qEnd;
              }
              if (nextVal != 0 && visited[nextRow][nextCol] != target) {
                visited[nextRow][nextCol] = target;
                q.add(new int[]{nextRow, nextCol});
              }
            }
          }
        }
      } // end of queue
//      System.out.println("target = " + target + ", " + step);
      if (!found) {
        return -1;
      }
    }
    return step;
  }

  private boolean isInRange(final int rows, final int cols, final int row, final int col) {
    return 0 <= row && row < rows && 0 <= col && col < cols;
  }

  private List<Integer> getTarget(final List<List<Integer>> forest) {
    final List<Integer> result = new ArrayList<>();
    for (int i = 0; i < forest.size(); i++) {
      final List<Integer> l = forest.get(i);
      for (int j = 0; j < l.size(); j++) {
        final int t = l.get(j);
        if (t != 0) {
          result.add(t);
//          valToPos.put(t, Arrays.asList(i, j));
        }
      }
    }
    Collections.sort(result);
    return result;
  }
}
