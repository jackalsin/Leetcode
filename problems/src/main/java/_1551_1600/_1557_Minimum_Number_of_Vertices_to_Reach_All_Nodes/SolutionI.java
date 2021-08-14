package _1551_1600._1557_Minimum_Number_of_Vertices_to_Reach_All_Nodes;

import java.util.ArrayList;
import java.util.List;

public final class SolutionI implements Solution {
  @Override
  public List<Integer> findSmallestSetOfVertices(final int n, final List<List<Integer>> edges) {
    final int[] indegrees = new int[n];
    final List<Integer> result = new ArrayList<>();
    for (final List<Integer> edge : edges) {
      final int from = edge.get(0), to = edge.get(1);
      indegrees[to]++;
    }
    for (int i = 0; i < n; ++i) {
      if (indegrees[i] == 0) result.add(i);
    }
    return result;
  }
}
