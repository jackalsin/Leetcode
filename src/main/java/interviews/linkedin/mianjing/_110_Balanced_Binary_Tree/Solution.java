package interviews.linkedin.mianjing._110_Balanced_Binary_Tree;

import utils.TreeNode;

public class Solution {
  public boolean isBalanced(TreeNode root) {
    return isBalancedInHeight(root) != -1;
  }

  private static int isBalancedInHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    final int leftHeight = isBalancedInHeight(root.left),
        rightHeight = isBalancedInHeight(root.right);

    if (leftHeight == -1 || rightHeight == -1) {
      return -1;
    }
    if (Math.abs(leftHeight - rightHeight) <= 1) {
      return Math.max(leftHeight, rightHeight) + 1;
    }
    return -1;
  }
}
