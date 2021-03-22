package byteDance._207_Course_Schedule;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 3/21/2021
 */
public final class SolutionI implements Solution {
  @Override
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    final Map<Integer, Set<Integer>> parentToChildren = new HashMap<>();
    final Map<Integer, Integer> parentCount = new HashMap<>();
    for (final int[] pre : prerequisites) {
      final int c = pre[0], p = pre[1];
      if (parentToChildren.computeIfAbsent(p, k -> new HashSet<>()).add(c)) {
        parentCount.put(c, parentCount.getOrDefault(c, 0) + 1);
      }
    }
    final Queue<Integer> q = new ArrayDeque<>();
    final Set<Integer> visited = new HashSet<>();
    for (int i = 0; i < numCourses; ++i) {
      if (!parentCount.containsKey(i)) {
        q.add(i);
        visited.add(i);
      }
    }
    while (!q.isEmpty()) {
      final int toRemove = q.remove();
      final Set<Integer> children = parentToChildren.getOrDefault(toRemove, Collections.emptySet());
      for (final int c : children) {
        final int curCount = parentCount.getOrDefault(c, 0) - 1;
        parentCount.put(c, curCount);
        if (curCount == 0 && visited.add(c)) {
          q.add(c);
        }
      }
    }
    return visited.size() == numCourses;
  }
}
