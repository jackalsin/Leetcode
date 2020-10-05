package linkedin._101_Symmetric_Tree;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 8/25/2019
 */
public class SolutionIV implements Solution {
  @Override
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    return isSymmetric(root.left, root.right);
  }

  private static boolean isSymmetric(final TreeNode left, final TreeNode right) {
    if (left == null && right == null) {
      return true;
    }
    if (left == null || right == null) {
      return false;
    }
    return left.val == right.val
        && isSymmetric(left.left, right.right)
        && isSymmetric(left.right, right.left);
  }
}
