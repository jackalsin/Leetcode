package _0201_0250._207_Course_Schedule;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 8/6/2017.
 */
public class Solution {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, Set<Integer>> courseToPrerequest = new HashMap<>();
    // generate unidirect graph
    for(int[] pair : prerequisites) {
      Set<Integer> prerequisite  = courseToPrerequest.getOrDefault(pair[0], new HashSet<>());
      prerequisite.add(pair[1]);
      courseToPrerequest.put(pair[0], prerequisite);
    }

    boolean[] visited = new boolean[numCourses];
    for (int course = 0; course < numCourses; course++) {
      if (!visited[course] && dfsHasCircle(courseToPrerequest,
          course, new HashSet<>(), visited)) {
        return false;
      }
    }
    return true;
  }

  private static boolean dfsHasCircle(Map<Integer, Set<Integer>> courseToPrerequest,
                         int course, Set<Integer> path, boolean[] visitted) {
    if (visitted[course]) return false;
    Set<Integer> pres = courseToPrerequest.getOrDefault(course, new HashSet<>());
    visitted[course] = true;
    path.add(course);
    for(int pre : pres) {
      if(path.contains(pre) || dfsHasCircle(courseToPrerequest, pre, path, visitted)) {
        return true;
      }
    }
    path.remove(course);
    return false;
  }
}
