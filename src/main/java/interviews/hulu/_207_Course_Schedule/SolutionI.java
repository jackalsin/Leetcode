package interviews.hulu._207_Course_Schedule;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 2/11/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    final Map<Integer, Set<Integer>> parentToChildren = new HashMap<>();
    final int[] indegrees = new int[numCourses];
    for (final int[] course : prerequisites) {
      final int p = course[0], c = course[1];
      if (parentToChildren.computeIfAbsent(p, k -> new HashSet<>()).add(c)) {
        indegrees[c]++;
      }
    }

    final Queue<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < numCourses; ++i) {
      if (indegrees[i] == 0) {
        q.add(i);
      }
    }
    int visited = 0;
    while (!q.isEmpty()) {
      final int p = q.remove();
      visited++;
      final Set<Integer> children = parentToChildren.getOrDefault(p, new HashSet<>());
      for (int c : children) {
        if (indegrees[c] == 1) {
          q.add(c);
        }
        indegrees[c]--;
      }
    }
    return visited == numCourses;
  }
}
