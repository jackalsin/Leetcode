package interviews.microsoft._112_Path_Sum;

import utils.binaryTree.TreeNode;

public class Solution {

  public boolean hasPathSum(TreeNode root, int sum) {
    return hasPathSum(root, sum, 0);
  }

  private boolean hasPathSum(TreeNode root, final int target, int curSum) {
    if (root == null) {
      return false;
    }
    if (root.left == null && root.right == null) {
      return curSum + root.val == target;
    }

    return hasPathSum(root.left, target, curSum + root.val)
        || hasPathSum(root.right, target, curSum + root.val);
  }

}
