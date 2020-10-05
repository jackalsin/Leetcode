package _0201_0250._210_Course_Schedule_II;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/8/2017.
 */
public class Solution {

  private Map<Integer, List<Integer>> prerequisites = new HashMap<>();
  private int[] incomingLinks;
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    incomingLinks = new int[numCourses];
    initializeGraph(prerequisites);
    return solve(numCourses);
  }

  private int[] solve(final int numCourses) {
    int[] result = new int[numCourses];
    int resultIndex = 0;
    final Deque<Integer> queue = new ArrayDeque<>();
    for(int i = 0; i < numCourses; ++i) {
      if (incomingLinks[i] == 0) {
        queue.addLast(i);
      }
    }

    // --- solve
    while (!queue.isEmpty()) {
      int prev = queue.removeFirst();
      result[resultIndex++] = prev;
      List<Integer> child = prerequisites.getOrDefault(prev, new ArrayList<>());
      for (int i : child) {
        incomingLinks[i]--;
        if (incomingLinks[i] == 0) queue.addLast(i);
      }
    }
    return resultIndex == numCourses ? result: new int[0];
  }

  private void initializeGraph(int[][] prerequisites) {
    for(int[] child : prerequisites) {
      List<Integer> prev = this.prerequisites.getOrDefault(child[1], new ArrayList<>());
      incomingLinks[child[0]]++;
      prev.add(child[0]);
      this.prerequisites.put(child[1], prev);
    }
  }
}
