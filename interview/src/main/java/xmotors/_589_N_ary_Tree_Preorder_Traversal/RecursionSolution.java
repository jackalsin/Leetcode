package xmotors._589_N_ary_Tree_Preorder_Traversal;

import definition.nAryTree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 5/19/2021
 */
public final class RecursionSolution implements Solution {
  @Override
  public List<Integer> preorder(Node root) {
    final List<Integer> result = new ArrayList<>();
    preorder(result, root);
    return result;
  }

  private static void preorder(final List<Integer> result, final Node root) {
    if (root == null) return;
    result.add(root.val);
    if (root.children == null) return;
    for (final Node c : root.children) {
      preorder(result, c);
    }
  }
}
