package interviews.linkedin._207_Course_Schedule;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 8/5/2019
 */
public final class SolutionI implements Solution {
  @Override
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    final Map<Integer, Integer> indegrees = new HashMap<>();
    final Map<Integer, Set<Integer>> parentToChildren = new HashMap<>();
    // init
    for (int i = 0; i < numCourses; i++) {
      indegrees.put(i, 0);
      parentToChildren.put(i, new HashSet<>());
    }
    // init 2 maps
    for (final int[] edge : prerequisites) {
      final int child = edge[0], parent = edge[1];
      indegrees.put(child, indegrees.get(child) + 1);
      final Set<Integer> children = parentToChildren.get(parent);
      children.add(child);
    }

    // bfs
    final Queue<Integer> q = new ArrayDeque<>();
    final Set<Integer> visited = new HashSet<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegrees.get(i) == 0) {
        q.add(i);
        visited.add(i);
      }
    }
    while (!q.isEmpty()) {
      final int toRemove = q.remove();
      final Set<Integer> children = parentToChildren.get(toRemove);
      for (int c : children) {
        final int degree = indegrees.get(c);
        if (degree == 1) {
          q.add(c);
          visited.add(c);
        }
        indegrees.put(c, degree - 1);
      }
    }
    return visited.size() == numCourses;
  }
}
