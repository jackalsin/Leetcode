package doordash._207_Course_Schedule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class DfsSolutionHasCycle implements Solution {

  @Override
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    final Map<Integer, List<Integer>> adjacentList = new HashMap<>();
    for (final int[] edge : prerequisites) {
      final int c = edge[0], p = edge[1];
      adjacentList.computeIfAbsent(p, k -> new ArrayList<>()).add(c);
    }
    final Set<Integer> visited = new HashSet<>();
    for (int i = 0; i < numCourses; ++i) {
      final Set<Integer> curPath = new HashSet<>();
      final boolean hasCycle = hasCycle(adjacentList, i, curPath, visited);
      if (hasCycle) return false;
    }
    return true;
  }

  private boolean hasCycle(final Map<Integer, List<Integer>> parentToChildren, final int start,
                           final Set<Integer> curPath, final Set<Integer> visited) {
    if (curPath.contains(start)) return true;
    if (visited.contains(start)) return false;
    curPath.add(start);
    visited.add(start);
    final List<Integer> children = parentToChildren.getOrDefault(start, Collections.emptyList());
    for (final int c : children) {
      if (hasCycle(parentToChildren, c, curPath, visited)) {
        return true;
      }
    }
    curPath.remove(start);
    return false;
  }
}
