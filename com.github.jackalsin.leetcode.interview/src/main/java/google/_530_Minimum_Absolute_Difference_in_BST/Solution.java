package google._530_Minimum_Absolute_Difference_in_BST;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 1/28/2018.
 */
public class Solution {
  private long min = Integer.MAX_VALUE;

  public int getMinimumDifference(TreeNode root) {
    final int[] minMax = {Integer.MAX_VALUE, Integer.MIN_VALUE};
    getMinimumDifference(root, minMax);
    return (int) min;
  }

  private void getMinimumDifference(TreeNode root, int[] minMax) {
    if (root == null) {
      return;
    }
    final int[] minMaxLeft = {Integer.MAX_VALUE, Integer.MIN_VALUE};
    final int[] minMaxRight = {Integer.MAX_VALUE, Integer.MIN_VALUE};
    getMinimumDifference(root.left, minMaxLeft);
    getMinimumDifference(root.right, minMaxRight);
    min = Math.min(min, Math.abs((long) root.val - (long) minMaxLeft[1]));
    min = Math.min(min, Math.abs((long) root.val - (long) minMaxRight[0]));
    minMax[0] = Math.min(minMaxLeft[0], root.val);
    minMax[1] = Math.max(minMaxRight[1], root.val);
  }
}
