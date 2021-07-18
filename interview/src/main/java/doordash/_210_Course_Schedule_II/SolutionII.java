package doordash._210_Course_Schedule_II;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class SolutionII implements Solution {
  @Override
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    final Map<Integer, Set<Integer>> parentToChildren = new HashMap<>();
    final int[] indegrees = new int[numCourses];
    for (final int[] e : prerequisites) {
      final int p = e[1], c = e[0];
      if (parentToChildren.computeIfAbsent(p, k -> new HashSet<>()).add(c)) {
        indegrees[c]++;
      }
    }
    final Queue<Integer> q = new ArrayDeque<>();
    final List<Integer> result = new ArrayList<>();
    for (int i = 0; i < numCourses; ++i) {
      if (indegrees[i] == 0) {
        q.add(i);
        result.add(i);
      }
    }
    while (!q.isEmpty()) {
      final int toRemove = q.remove();
      for (final int next : parentToChildren.getOrDefault(toRemove, Collections.emptySet())) {
        indegrees[next]--;
        if (indegrees[next] == 0) {
          q.add(next);
          result.add(next);
        }
      }
    }

    return result.size() == numCourses ? result.stream().mapToInt(x -> x).toArray() : new int[0];
  }
}
