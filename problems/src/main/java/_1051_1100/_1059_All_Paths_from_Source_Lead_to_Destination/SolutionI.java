package _1051_1100._1059_All_Paths_from_Source_Lead_to_Destination;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 11/1/2020
 */
public final class SolutionI implements Solution {
  private final Map<Integer, Set<Integer>> adjacentList = new HashMap<>();
  private int destination;

  public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
    this.destination = destination;
    for (final int[] e : edges) {
      adjacentList.computeIfAbsent(e[0], k -> new HashSet<>()).add(e[1]);
    }
    final Set<Integer> visited = new HashSet<>();
    // 1) no cycle
    // 2) all ends on destination
    return isValidDfs(source, visited, new HashSet<>());
  }

  private boolean isValidDfs(final int start, final Set<Integer> visited, final Set<Integer> curPath) {
//    System.out.println("Checking start = " + start + ", cur Path = " + curPath);
    if (curPath.contains(start)) {
//      System.out.println("Found circle = " + curPath);
      return false; // cycle
    }
    if (visited.contains(start)) {
      return true;
    }
    final Set<Integer> neighbors = adjacentList.get(start);
    if (neighbors == null) {
      if (start != this.destination) {
//        System.out.println("Terminating in " + this.destination);
      }
      return start == this.destination;
    }

    if (start == this.destination) {
//      System.out.println("Found destination " + this.destination + " has neighbors = " + neighbors);
      return false; // directly returns false since neighbors cannot be null;
    }
    visited.add(start);
    curPath.add(start);
    for (final int next : neighbors) {
      if (!isValidDfs(next, visited, curPath)) {
        return false;
      }
    }
    curPath.remove(start);
    return true;
  }
}
