package _1651_1700._1644_Lowest_Common_Ancestor_of_a_Binary_Tree_II;

import definition.binaryTree.TreeNode;

public final class SolutionI implements Solution {
  private int found = 0;

  public TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return root;
    final TreeNode left = helper(root.left, p, q),
        right = helper(root.right, p, q);
    if (p == root || q == root) {
      found++;
      return root;
    }
    if (left == null) return right;
    else if (right == null) return left;
    else return root;
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    final TreeNode result = helper(root, p, q);
    return found == 2 ? result : null;
  }
}
