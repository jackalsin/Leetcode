package uber._207_Course_Schedule;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
  private final Map<Integer, Set<Integer>> toParents = new HashMap<>();

  /**
   * Time Complexity: O(N^2)
   * Worst case: a -> b -> c -> d ->
   *
   * @param numCourses
   * @param prerequisites
   * @return
   */
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] incomingLinks = new int[numCourses];
    /* prerequisite[0] is child, prerequisite[1] is parent */
    for (final int[] prerequisite : prerequisites) {
      toParents.putIfAbsent(prerequisite[0], new HashSet<>());
      toParents.get(prerequisite[0]).add(prerequisite[1]);
      incomingLinks[prerequisite[1]]++;
    }

    // loop all the nodes
    final Queue<Integer> queue = new ArrayDeque<>();
    final boolean[] visited = new boolean[numCourses];
    int finishedCount = 0;
    do {
      for (int i = 0; i < numCourses; i++) {
        if (incomingLinks[i] == 0 && !visited[i]) {
          queue.add(i);
          visited[i] = true;
        }
      }
      if (queue.isEmpty()) {
        break;
      }
      while (!queue.isEmpty()) {
        final int toRemove = queue.remove();
        finishedCount++;
        final Set<Integer> parents = toParents.getOrDefault(toRemove, new HashSet<>());
        for (int parent : parents) {
          incomingLinks[parent]--;
        }
      }
    } while (true);

    return numCourses == finishedCount;
  }
}
