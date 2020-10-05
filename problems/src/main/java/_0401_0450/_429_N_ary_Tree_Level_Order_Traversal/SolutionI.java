package _0401_0450._429_N_ary_Tree_Level_Order_Traversal;


import definition.nAryTree.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 5/25/2020
 */
public final class SolutionI implements Solution {
  @Override
  public List<List<Integer>> levelOrder(Node root) {
    final List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    final Queue<Node> q = new ArrayDeque<>() {{
      add(root);
    }};
    while (!q.isEmpty()) {
      final int size = q.size();
      final List<Integer> cur = new ArrayList<>();
      result.add(cur);
      for (int i = 0; i < size; ++i) {
        final Node toRemove = q.remove();
        cur.add(toRemove.val);
        if (toRemove.children != null) {
          q.addAll(toRemove.children);
        }
      }
    }
    return result;
  }
}
