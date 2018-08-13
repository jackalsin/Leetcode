package interviews.microsoft.noodleEssence._207_Course_Schedule;

import java.util.*;

public class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    final Map<Integer, Integer> parentCounts = new HashMap<>();
    final Map<Integer, Set<Integer>> parentToChild = new HashMap<>();
    for (final int[] pre : prerequisites) {
      final int parent = pre[1], child = pre[0];
      final Set<Integer> children = parentToChild.getOrDefault(parent, new HashSet<>());
      parentToChild.put(parent, children);
      if (!children.contains(child)) {
        children.add(child);
        parentCounts.put(child, parentCounts.getOrDefault(child, 0) + 1);
      }
    } // end of the for loop

    final Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < numCourses; i++) {
      if (!parentCounts.containsKey(i)) {
        queue.add(i);
      }
    }
    int count = 0;
    while (!queue.isEmpty()) {
      final int toRemove = queue.remove();
      count++;
      final Set<Integer> children = parentToChild.getOrDefault(toRemove, new HashSet<>());
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
    return count == numCourses;
  }
}
