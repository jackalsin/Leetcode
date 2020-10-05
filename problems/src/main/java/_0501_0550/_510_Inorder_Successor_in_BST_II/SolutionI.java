package _0501_0550._510_Inorder_Successor_in_BST_II;

import definition._510_Inorder_Successor_in_BST_II.Node;

/**
 * @author jacka
 * @version 1.0 on 12/25/2019
 */
public final class SolutionI implements Solution {
  @Override
  public Node inorderSuccessor(Node x) {
    if (x == null) {
      return null;
    }
    final Node rightCandidate = getFirst(x.right);
    if (rightCandidate != null) {
      return rightCandidate;
    }
    while (x.parent != null && x.parent.right == x) {
      x = x.parent;
    }
    return x.parent;
  }

  private static Node getFirst(Node root) {
    if (root == null) return null;
    while (root.left != null) {
      root = root.left;
    }
    return root;
  }
}
