package byteDance._124_Binary_Tree_Maximum_Path_Sum;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 3/30/2021
 */
public final class SolutionII implements Solution {
  private long sum = Long.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    maxPathSumHelper(root);
    return (int) sum;
  }

  private int maxPathSumHelper(final TreeNode root) {
    if (root == null) {
      return 0;
    }
    final int left = maxPathSumHelper(root.left),
        right = maxPathSumHelper(root.right),
        sum = Math.max(0, left) + Math.max(0, right) + root.val;
    this.sum = Math.max(Math.max(this.sum, sum), root.val);
    return Math.max(root.val, root.val + Math.max(left, right));
  }
}
