package interviews.linkedin._210_Course_Schedule_II;

import java.util.*;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/6/18
 */
public class Solution {

  /**
   * Assume, <tt>n</tt> courses and <tt>E</tt> prerequisites
   * <p>
   * Time Complexity: O (N + E)
   *
   * @param numCourses
   * @param prerequisites
   * @return
   */
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    // remaining precourse
    final Map<Integer, Integer> incomingLinks = new HashMap<>();
    final Map<Integer, List<Integer>> postCourses = new HashMap<>();
    for (int[] pair : prerequisites) { // O(E)
      final int post = pair[0], pre = pair[1];
      incomingLinks.put(post, incomingLinks.getOrDefault(post, 0) + 1);
      postCourses.computeIfAbsent(pre, p -> new ArrayList<>()).add(post);
    }

    final Queue<Integer> q = new ArrayDeque<>();
    int k = 0;
    final int[] result = new int[numCourses];
    final Set<Integer> visited = new HashSet<>();
    for (int i = 0; i < numCourses; ++i) {
      if (!incomingLinks.containsKey(i)) {
        q.add(i);
        visited.add(i);
      }
    }
    while (!q.isEmpty()) { // O (N + E)
      final int toRemove = q.remove();
      result[k++] = toRemove;
      final List<Integer> posts = postCourses.getOrDefault(toRemove, new ArrayList<>());
      for (int post : posts) {
        final int incomingLink = incomingLinks.get(post);
        if (incomingLink == 1) {
          assert !visited.contains(post);
          q.add(post);
          visited.add(post);
        }
        incomingLinks.put(post, incomingLink - 1);
      }
    }
    return k == numCourses ? result : new int[0];
  }

}
