package interviews.google._210_Course_Schedule_II;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 1/15/2018.
 */
public class Solution {

  private Map<Integer, List<Integer>> preToChildren = new HashMap<>();
  private int[] incomingLinks;

  /**
   * This algorithm
   */
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    incomingLinks = new int[numCourses];
    initializeGraph(numCourses, prerequisites);
    return solve(numCourses);
  }

  private int[] solve(int numCourses) {
    final int[] res = new int[numCourses];
    final Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < numCourses; i++) {
      if (incomingLinks[i] == 0) {
        queue.add(i);
      }
    }
    int resultIndex = 0;
    while (!queue.isEmpty()) {
      final int prev = queue.remove();
      res[resultIndex++] = prev;
      final List<Integer> children = preToChildren.getOrDefault(prev, new ArrayList<>());
      for (int child : children) {
        incomingLinks[child]--;
        if (incomingLinks[child] == 0) {
          queue.add(child);
        }
      }
    }

    return resultIndex == numCourses ? res : new int[0];
  }

  private void initializeGraph(final int numCourses, final int[][] prerequisites) {
    final List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      res.add(new ArrayList<>());
    }
    for (final int[] prerequisite : prerequisites) {
      final List<Integer> pre = this.preToChildren.getOrDefault(prerequisite[1], new ArrayList<>());
      incomingLinks[prerequisite[0]]++;
      pre.add(prerequisite[0]);
      this.preToChildren.put(prerequisite[1], pre);
    }
  }

}
