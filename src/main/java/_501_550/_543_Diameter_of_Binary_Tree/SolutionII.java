package _501_550._543_Diameter_of_Binary_Tree;

import utils.TreeNode;

public final class SolutionII implements Solution {
  private int max = 0;

  @Override
  public int diameterOfBinaryTree(TreeNode root) {
    dfs(root);
    return max;
  }

  private int dfs(TreeNode root) {
    if (root == null) {
      return 0;
    }
    final int left = dfs(root.left), right = dfs(root.right);
    max = Math.max(max, left + right);
    return Math.max(left, right) + 1;
  }
}
