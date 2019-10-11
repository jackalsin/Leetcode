package _0951_1000._965_Univalued_Binary_Tree;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 10/11/2019
 */
public final class SolutionI implements Solution {
  @Override
  public boolean isUnivalTree(TreeNode root) {
    if (root == null) {
      return true;
    }
    final boolean left = isUnivalTree(root.left),
        right = isUnivalTree(root.right);

    return left && (root.left == null || root.val == root.left.val)
        && right && (root.right == null || root.val == root.right.val);
  }
}
