package facebook._210_Course_Schedule_II;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
//  Input: 2, [[1,0]]
//  Output: [0,1]

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    final Map<Integer, Integer> parentCounts = new HashMap<>();

    // do parent first
    final Map<Integer, Set<Integer>> parentToChildren = new HashMap<>();
    for (final int[] pre : prerequisites) {
      final int child = pre[0], parent = pre[1];
      parentToChildren.putIfAbsent(parent, new HashSet<>());
      final Set<Integer> children = parentToChildren.get(parent);
      children.add(child);
      parentCounts.put(child, parentCounts.getOrDefault(child, 0) + 1);
    }

    final Queue<Integer> queue = new ArrayDeque<>();
    final List<Integer> result = new ArrayList<>();

    for (int i = 0; i < numCourses; i++) {
      if (!parentCounts.containsKey(i)) {
        queue.add(i);
      }
    }


    while (!queue.isEmpty()) {
      final int parent = queue.remove();
      result.add(parent);
      final Set<Integer> children = parentToChildren.getOrDefault(parent, new HashSet<>());
      for (final int child : children) {
        int parentCount = parentCounts.get(child);
        if (parentCount == 1) {
          parentCounts.remove(child);
          queue.add(child);
        } else {
          parentCounts.put(child, parentCount - 1);
        }
      }
    }

    if (result.size() != numCourses) { // not path
      return new int[0];
    }
    final int[] res = new int[numCourses];
    for (int i = 0; i < result.size(); i++) {
      res[i] = result.get(i);
    }
    return res;
  }
}
