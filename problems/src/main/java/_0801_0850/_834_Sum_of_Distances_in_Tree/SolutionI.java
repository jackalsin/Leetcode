package _0801_0850._834_Sum_of_Distances_in_Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 9/2/2020
 */
public final class SolutionI implements Solution {
  private int[] result, childrenCount;
  private final List<Set<Integer>> adjacentList = new ArrayList<>();
  private int N;
  // <a href="https://leetcode.com/problems/sum-of-distances-in-tree/discuss/130583/C%2B%2BJavaPython-Pre-order-and
  // -Post-order-DFS-O(N)"></a>
  public int[] sumOfDistancesInTree(int N, int[][] edges) {
    this.N = N;
    result = new int[N];
    childrenCount = new int[N];
    for (int i = 0; i < N; ++i) {
      adjacentList.add(new HashSet<>());
    }
    for (final int[] e : edges) {
      final int e0 = e[0], e1 = e[1];
      adjacentList.get(e0).add(e1);
      adjacentList.get(e1).add(e0);
    }
    dfs(0, -1);
//    System.out.println(Arrays.toString(result));
//    System.out.println(Arrays.toString(childrenCount));
    dfs2(0, -1);
//    System.out.println(Arrays.toString(result));
//    System.out.println(Arrays.toString(childrenCount));
    return result;
  }

  private void dfs2(final int root, final int prev) {
    for (final int i : adjacentList.get(root)) {
      if (i == prev) continue;
      result[i] = result[root] - childrenCount[i] + N - childrenCount[i];
      dfs2(i, root);
    }
  }

  private void dfs(final int root, final int prev) {
    for (int i : adjacentList.get(root)) {
      if (i == prev) continue;
      dfs(i, root);
      childrenCount[root] += childrenCount[i];
      result[root] += result[i] + childrenCount[i];
    }
    childrenCount[root]++;
  }
}
