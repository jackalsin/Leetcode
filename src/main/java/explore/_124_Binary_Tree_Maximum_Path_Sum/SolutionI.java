package explore._124_Binary_Tree_Maximum_Path_Sum;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 4/29/2020
 */
public final class SolutionI implements Solution {
  private int max = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    helper(root);
    return max;
  }

  private int helper(final TreeNode root) {
    if (root == null) {
      return 0;
    }
    final int left = helper(root.left), right = helper(root.right);
    final int res = root.val + Math.max(0, Math.max(left, right)),
        sum = root.val + Math.max(0, left) + Math.max(0, right);
    max = Math.max(sum, max);
    return res;
  }
}
