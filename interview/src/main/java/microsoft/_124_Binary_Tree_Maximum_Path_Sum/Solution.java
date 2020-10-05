package microsoft._124_Binary_Tree_Maximum_Path_Sum;

import definition.binaryTree.TreeNode;

public class Solution {
  private int sum = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    maxPathSumHelper(root);
    return sum;
  }

  private int maxPathSumHelper(TreeNode root) {
    if (root == null) {
      return 0;
    }
    final int left = Math.max(maxPathSumHelper(root.left), 0),
        right = Math.max(maxPathSumHelper(root.right), 0);
    sum = Math.max(sum, left + right + root.val);
    return Math.max(left, right) + root.val;
  }
}
