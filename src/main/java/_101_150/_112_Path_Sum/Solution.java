package _101_150._112_Path_Sum;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 6/21/2017.
 */
public class Solution {
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) return false;
    if (root.left == null && root.right == null && root.val == sum) return true;
    return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
  }

}