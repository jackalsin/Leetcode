package linkedin._270_Closest_Binary_Search_Tree_Value;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 9/2/2019
 */
public final class SolutionIII implements Solution {
  private long val = 0;
  private double minDiff = Long.MAX_VALUE;

  public int closestValue(TreeNode root, double target) {
    closestValueHelper(root, target);
    return (int) val;
  }

  private void closestValueHelper(final TreeNode root, final double target) {
    if (root == null) {
      return;
    }
    double curDiff = Math.abs(root.val - target);
    if (curDiff < minDiff) {
      val = root.val;
      minDiff = curDiff;
    }
    if (target < root.val) {
      closestValueHelper(root.left, target);
    } else if (target > root.val) {
      closestValueHelper(root.right, target);
    }
  }
}
