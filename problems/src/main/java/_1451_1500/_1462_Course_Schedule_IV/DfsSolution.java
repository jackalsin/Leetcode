package _1451_1500._1462_Course_Schedule_IV;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class DfsSolution implements Solution {
  @Override
  public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
    final Map<Integer, Set<Integer>> parentToChildren = new HashMap<>();
    for (final int[] course : prerequisites) {
      final int c = course[1], p = course[0];
      parentToChildren.computeIfAbsent(p, k -> new HashSet<>()).add(c);
    }
    final List<Boolean> result = new ArrayList<>();
    for (final int[] q : queries) {
      final int start = q[0], target = q[1];
      result.add(canReach(parentToChildren, start, target, new HashSet<>()));
    }
    return result;
  }

  private static boolean canReach(final Map<Integer, Set<Integer>> parentToChildren,
                                  final int start, final int target, final Set<Integer> visited) {
    if (start == target) return true;
    if (!visited.add(start)) return false;
    final Set<Integer> children = parentToChildren.getOrDefault(start, Collections.emptySet());
    for (final int c : children) {
      if (canReach(parentToChildren, c, target, visited)) return true;
    }
    return false;
  }
}
