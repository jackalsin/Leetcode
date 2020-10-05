package byteDance._124_Binary_Tree_Maximum_Path_Sum;

import definition.binaryTree.TreeNode;

/**
 * @author zhixi
 * @version 1.0 on 5/7/2020
 */
public final class SolutionI implements Solution {
  private int max = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    pathSum(root);
    return max;
  }

  private int pathSum(final TreeNode root) {
    if (root == null) {
      return 0;
    }
    final int left = pathSum(root.left), right = pathSum(root.right);
    final int maxSum = Math.max(root.val, root.val + Math.max(0, left) + Math.max(0, right));
    max = Math.max(max, maxSum);
    return Math.max(root.val, root.val + Math.max(left, right));
  }
}
