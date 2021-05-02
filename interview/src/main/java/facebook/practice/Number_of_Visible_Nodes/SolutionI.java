package facebook.practice.Number_of_Visible_Nodes;

import java.util.ArrayList;

/**
 * @author jacka
 * @version 1.0 on 5/2/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int[] countOfNodes(final Node root, final ArrayList<Query> queries,
                            final String s) {
    final int qLen = queries.size();
    final int[] result = new int[qLen];
    for (int i = 0; i < qLen; ++i) {
      final Query q = queries.get(i);
      result[i] = count(root, q, s, false);
    }
    return result;
  }

  private int count(final Node root, final Query q, final String s, boolean shouldCount) {
    if (root == null) return 0;
    shouldCount |= q.u == root.val;
    int res = shouldCount && s.charAt(root.val - 1) == q.c ? 1 : 0;
    for (final Node c : root.children) {
      res += count(c, q, s, shouldCount);
    }
    return res;
  }
}
