package airbnb._1557_Minimum_Number_of_Vertices_to_Reach_All_Nodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/3/2021
 */
public final class SolutionI implements Solution {
  @Override
  public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    if (edges == null || edges.isEmpty()) return Collections.emptyList();
    final int[] indegrees = new int[n];
    for (final List<Integer> edge : edges) {
      final int from = edge.get(0), to = edge.get(1);
      indegrees[to]++;
    }
    final List<Integer> result = new ArrayList<>();
    for (int i = 0; i < indegrees.length; ++i) {
      if (indegrees[i] == 0) result.add(i);
    }
    return result;
  }
}
