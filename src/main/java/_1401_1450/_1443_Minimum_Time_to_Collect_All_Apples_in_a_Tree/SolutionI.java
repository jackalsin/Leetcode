package _1401_1450._1443_Minimum_Time_to_Collect_All_Apples_in_a_Tree;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class SolutionI implements Solution {
  private final Map<Integer, List<Integer>> adjacent = new HashMap<>();

  public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
    // build
    for (final int[] e : edges) {
      adjacent.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
      adjacent.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
    }
    //
    final int minTime = minTime(0, hasApple, -1);
    return minTime == -1 ? 0 : minTime;
  }

  /**
   * @return minTime to collect all apples, otherwise, -1;
   */
  private int minTime(final int start, final List<Boolean> hasApple, final int parent) {

    final List<Integer> neighbors = adjacent.getOrDefault(start, new ArrayList<>());
    int minToGetAll = 0;
    for (int next : neighbors) {
      if (next == parent) continue;
      int minToGetChildren = minTime(next, hasApple, start);
      if (minToGetChildren == -1) continue;
      minToGetAll += 2 + minToGetChildren;
    }
    if (hasApple.get(start)) {
      return minToGetAll == 0 ? 0 : minToGetAll;
    } else {
      return minToGetAll == 0 ? -1 : minToGetAll;
    }
  }
}
