package doordash._207_Course_Schedule;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class SolutionII implements Solution {
  @Override
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    final Map<Integer, List<Integer>> parentToChildren = new HashMap<>();
    final int[] indegrees = new int[numCourses];
    for (final int[] pre : prerequisites) {
      final int p = pre[1], c = pre[0];
      parentToChildren.computeIfAbsent(p, k -> new ArrayList<>()).add(c);
      indegrees[c]++;
    }
    final Queue<Integer> q = new ArrayDeque<>();
    int count = 0;
    for (int i = 0; i < numCourses; ++i) {
      if (indegrees[i] == 0) {
        q.add(i);
        count++;
      }
    }
    while (!q.isEmpty()) {
      final int toRemove = q.remove();
      for (final int next : parentToChildren.getOrDefault(toRemove, Collections.emptyList())) {
        indegrees[next]--;
        if (indegrees[next] == 0) {
          q.add(next);
          count++;
        }
      }
    }
    return count == numCourses;
  }
}
