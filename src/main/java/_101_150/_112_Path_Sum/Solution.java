package _101_150._112_Path_Sum;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 6/21/2017.
 */
public class Solution {
  public boolean hasPathSum(TreeNode root, int sum) {
    return hasPathSum(root, sum, 0);
  }

  private boolean hasPathSum(TreeNode root, final int targetSum, int curSum) {
    if (root == null) {
      return targetSum == curSum;
    } else {
      return hasPathSum(root.left, targetSum, curSum + root.val) || hasPathSum(root.right,
          targetSum, curSum + root.val);
    }
  }
}