package interviews.linkedin._207_Course_Schedule;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 8/5/2019
 */
public final class SolutionII implements Solution {
  @Override
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    final Map<Integer, Integer> indegree = new HashMap<>();
    final Map<Integer, List<Integer>> parentToChildren = new HashMap<>();
    for (int i = 0; i < numCourses; i++) {
      indegree.put(i, 0);
    }

    // init edge
    for (final int[] e : prerequisites) {
      final int child = e[0], parent = e[1];
      if (!parentToChildren.containsKey(parent)) {
        parentToChildren.put(parent, new ArrayList<>());
      }
      parentToChildren.get(parent).add(child);
      indegree.put(child, indegree.get(child) + 1);
    }
    // bfs
    final Queue<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegree.get(i) == 0) {
        q.add(i);
        indegree.remove(i);
      }
    }
    while (!q.isEmpty()) {
      final int toRemove = q.remove();
      final List<Integer> children = parentToChildren.getOrDefault(toRemove, new ArrayList<>());
      for (int c : children) {
        if (!indegree.containsKey(c)) continue;
        final int d = indegree.get(c);
        if (d == 1) {
          indegree.remove(c);
          q.add(c);
        } else {
          indegree.put(c, d - 1);
        }
      }
    }

    return indegree.isEmpty();
  }
}
