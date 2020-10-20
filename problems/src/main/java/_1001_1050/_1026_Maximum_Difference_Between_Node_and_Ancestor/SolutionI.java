package _1001_1050._1026_Maximum_Difference_Between_Node_and_Ancestor;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 10/19/2020
 */
public final class SolutionI implements Solution {
  private int res = 0;

  public int maxAncestorDiff(TreeNode root) {
    if (root == null) return res;
    maxAncestorDiff(root.left, root.val, root.val);
    maxAncestorDiff(root.right, root.val, root.val);
    return res;
  }

  private void maxAncestorDiff(final TreeNode root, final int min, final int max) {
    if (root == null) {
      return;
    }
    this.res = Math.max(this.res, Math.abs(min - root.val));
    this.res = Math.max(this.res, Math.abs(max - root.val));
    final int nextMin = Math.min(root.val, min), nextMax = Math.max(max, root.val);
    maxAncestorDiff(root.left, nextMin, nextMax);
    maxAncestorDiff(root.right, nextMin, nextMax);
  }
}
