package doordash._207_Course_Schedule;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class VisitSolution implements Solution {
  @Override
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    final Map<Integer, Set<Integer>> parentToChildren = new HashMap<>();
    final int[] indegree = new int[numCourses];
    for (final int[] edge : prerequisites) {
      final int p = edge[1], c = edge[0];
      if (parentToChildren.computeIfAbsent(p, k -> new HashSet<>()).add(c)) {
        indegree[c]++;
      }
    }
    int visited = 0;

    final Queue<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < numCourses; ++i) {
      if (indegree[i] == 0) {
        q.add(i);
        visited++;

      }
    }
    while (!q.isEmpty()) {
      final int toRemove = q.remove();
      for (int next : parentToChildren.getOrDefault(toRemove, Collections.emptySet())) {
        indegree[next]--;
        if (indegree[next] == 0) {
          q.add(next);
          visited++;
        }
      }
    }
    return visited == numCourses;
  }
}
