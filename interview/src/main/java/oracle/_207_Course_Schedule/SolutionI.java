package oracle._207_Course_Schedule;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 12/3/2019
 */
public final class SolutionI implements Solution {
  @Override
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    if (numCourses < 0 || prerequisites == null || prerequisites.length == 0) {
      return true;
    }
    final Map<Integer, List<Integer>> parentToChildren = new HashMap<>();
    final Map<Integer, Integer> parentCounts = new HashMap<>();
    for (int i = 0; i < numCourses; ++i) {
      parentCounts.put(i, 0);
      parentToChildren.put(i, new ArrayList<>());
    }
    for (final int[] p : prerequisites) {
      final int child = p[0], parent = p[1];
      parentToChildren.get(parent).add(child);
      parentCounts.put(child, parentCounts.get(child) + 1);
    }

    final Queue<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < numCourses; ++i) {
      if (parentCounts.get(i) == 0) {
        q.add(i);
      }
    }

    while (!q.isEmpty()) {
      final int toRemove = q.remove();
      final List<Integer> children = parentToChildren.getOrDefault(toRemove, new ArrayList<>());
      for (int c : children) {
        final int prevCount = parentCounts.get(c);
        if (prevCount == 1) {
          q.add(c);
        }
        parentCounts.put(c, prevCount - 1);
      }
    }

    for (int i = 0; i < numCourses; ++i) {
      if (parentCounts.get(i) != 0) {
        return false;
      }
    }
    return true;
  }
}
