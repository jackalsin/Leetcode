package _0101_0150._124_Binary_Tree_Maximum_Path_Sum;

import utils.binaryTree.TreeNode;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/26/2017.
 */
public class Solution {
  private int maxValue;

  public int maxPathSum(TreeNode root) {
    maxValue = Integer.MIN_VALUE;
    maxPathSumDown(root);
    return maxValue;
  }

  private int maxPathSumDown(TreeNode root) {
    if (root == null) return 0;
    int left = Math.max(maxPathSumDown(root.left), 0);
    int right = Math.max(0, maxPathSumDown(root.right));
    maxValue = Math.max(maxValue, left + right + root.val);
    return Math.max(left, right) + root.val;
  }
}
