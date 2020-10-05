package _0551_0600._589_N_ary_Tree_Preorder_Traversal;

import definition.nAryTree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/1/2020
 */
public final class RecursionSolution implements Solution {
  @Override
  public List<Integer> preorder(Node root) {
    final List<Integer> result = new ArrayList<>();
    if (root == null)return result;
    preorder(result, root);
    return result;
  }

  private static void preorder(final List<Integer> result, final Node root) {
    result.add(root.val);
    if (root.children == null) {
      return;
    }
    for (Node c : root.children) {
      preorder(result, c);
    }
  }
}
