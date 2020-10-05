package _0751_0800._797_All_Paths_From_Source_to_Target;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/30/2020
 */
public final class SolutionI implements Solution {
  private final BitSet visited = new BitSet();
  private final List<List<Integer>> result = new ArrayList<>();
  private final List<Integer> curPath = new ArrayList<>() {{
    add(0);
  }};
  private int[][] graph;
  private int n, target;

  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    n = graph.length;
    target = n - 1;
    this.graph = graph;
    dfs(0);
    return result;
  }

  private void dfs(final int start) {
    if (start == target) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    for (int next : graph[start]) {
      if (visited.get(next)) continue;
      visited.set(next);
      curPath.add(next);
      dfs(next);
      curPath.remove(curPath.size() - 1);
      visited.set(next, false);
    }
  }
}
