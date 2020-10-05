package linkedin._236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SolutionII implements Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || p == root || root == q) {
      return root;
    }

    final TreeNode leftRoot = lowestCommonAncestor(root.left, p, q),
        rightRoot = lowestCommonAncestor(root.right, p, q);

    if (leftRoot != null && rightRoot != null) {
      return root;
    } else {
      return leftRoot == null ? rightRoot : leftRoot;
    }

  }
}
