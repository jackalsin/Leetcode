package interviews.google._210_Course_Schedule_II;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 1/15/2018.
 */
public class Solution {

  /**
   * This algorithm
   *
   * @param numCourses
   * @param prerequisites
   * @return
   */
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    final int[] nums = new int[numCourses];
    final List<List<Integer>> edges = initializeGraph(numCourses, prerequisites);
    final Queue<Integer> queue = new ArrayDeque<>();

    return nums;
  }

  private static List<List<Integer>> initializeGraph(final int numCourses, final int[][] prerequisites) {
    final List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      res.add(new ArrayList<>());
    }
    for (final int[] prerequisite : prerequisites) {

    }
    return res;
  }

}
