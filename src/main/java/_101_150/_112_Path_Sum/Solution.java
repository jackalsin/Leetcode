package _101_150._112_Path_Sum;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 6/21/2017.
 */
public class Solution {
  public boolean hasPathSum(TreeNode root, int sum) {
<<<<<<< HEAD
    if (root == null) return false;
=======
>>>>>>> 799a9f9aed001a0b11139ba2977d4f1156b7c53b
    return hasPathSum(root, sum, 0);
  }

  private boolean hasPathSum(TreeNode root, final int targetSum, int preSum) {
    if (root.left == null && root.right == null) {
      return targetSum == preSum + root.val;
    } else{
      boolean isPathSumLeft = root.left != null && hasPathSum(root.left, targetSum, preSum + root.val);
      boolean isPathSumRight = root.right != null && hasPathSum(root.right, targetSum, preSum
                                                                                           + root.val);
      return isPathSumLeft || isPathSumRight;
    }
  }
}