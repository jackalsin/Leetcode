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

/**
 * @author jacka
 * @version 1.0 on 7/7/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    if (numCourses <= 0) return new int[]{};
    final int[] incomings = new int[numCourses];
    final Map<Integer, Set<Integer>> parentToChildren = new HashMap<>();
    for (final int[] course : prerequisites) {
      final int c = course[0], p = course[1];
      if (parentToChildren.computeIfAbsent(p, k -> new HashSet<>()).add(c)) {
        incomings[c]++;
      }
    }
    final Queue<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < numCourses; ++i) {
      if (incomings[i] == 0) q.add(i);
    }
    final List<Integer> result = new ArrayList<>();
    while (!q.isEmpty()) {
      final int toRemove = q.remove();
      result.add(toRemove);
      for (final int c : parentToChildren.getOrDefault(toRemove, Collections.emptySet())) {
        if (--incomings[c] == 0) {
          q.add(c);
        }
      }
    }
    if (result.size() != numCourses) {
      return new int[]{};
    }
    return result.stream().mapToInt(x -> x).toArray();
  }
}
