package microsoft.noodleEssence._210_Course_Schedule_II;

import java.util.*;

public class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    final Map<Integer, Integer> parentCounts = new HashMap<>();
    final Map<Integer, Set<Integer>> parentToChildren = new HashMap<>();

    // init graph
    for (final int[] pre : prerequisites) {
      final int parent = pre[1], child = pre[0];
      final Set<Integer> children = parentToChildren.getOrDefault(parent, new HashSet<>());
      parentToChildren.put(parent, children);
      if (!children.contains(child)) {
        children.add(child);
        parentCounts.put(child, parentCounts.getOrDefault(child, 0) + 1);
      }
    }
    final Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < numCourses; i++) {
      if (!parentCounts.containsKey(i)) {
        queue.add(i);
      }
    }

    final int[] result = new int[numCourses];
    int k = 0;

    while (!queue.isEmpty()) {
      final int toRemove = queue.remove();
      result[k++] = toRemove;
      final Set<Integer> children = parentToChildren.getOrDefault(toRemove, new HashSet<>());
      for (int child : children) {
        final int parentCount = parentCounts.get(child);
        if (parentCount == 1) {
          parentCounts.remove(child);
          queue.add(child);
        } else {
          parentCounts.put(child, parentCount - 1);
        }
      }
    }
    return k == numCourses ? result : new int[0];
  }
}
