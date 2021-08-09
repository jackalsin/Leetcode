package linkedin._101_Symmetric_Tree;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 8/8/2021
 */
public final class SolutionV implements Solution {
  @Override
  public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return helper(root.left, root.right);
  }

  private static boolean helper(final TreeNode left, final TreeNode right) {
    if (left == null && right == null) return true;
    if (left == null || right == null || left.val != right.val) return false;
    return helper(left.right, right.left)
        && helper(right.right, left.left);
  }
}
