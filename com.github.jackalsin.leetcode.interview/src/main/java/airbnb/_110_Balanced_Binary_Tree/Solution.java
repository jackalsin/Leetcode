package airbnb._110_Balanced_Binary_Tree;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 1/26/2019.
 */
public class Solution {
  public boolean isBalanced(TreeNode root) {
    return dfs(root) != -1;
  }

  public int dfs(TreeNode root) {
    if (root == null) {
      return 0;
    }
    final int leftHeight = dfs(root.left);
    if (leftHeight == -1) {
      return -1;
    }
    final int rightHeight = dfs(root.right);
    if (rightHeight == -1) {
      return -1;
    }
    if (Math.abs(leftHeight - rightHeight) <= 1) {
      return 1 + Math.max(leftHeight, rightHeight);
    }
    return -1;
  }
}
