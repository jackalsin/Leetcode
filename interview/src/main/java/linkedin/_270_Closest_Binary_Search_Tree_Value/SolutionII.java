package linkedin._270_Closest_Binary_Search_Tree_Value;

import definition.binaryTree.TreeNode;

public final class SolutionII implements Solution {
  private int minRootVal = Integer.MAX_VALUE;
  private double minBias = Double.MAX_VALUE;

  public int closestValue(TreeNode root, double target) {
    if (root == null) {
      return minRootVal;
    }
    dfs(root, target);
    return minRootVal;
  }

  private void dfs(final TreeNode root, final double target) {
    if (root == null) {
      return;
    }
    final double curDiff = Math.abs(target - root.val);
    if (minBias > curDiff) {
      minBias = curDiff;
      minRootVal = root.val;
    }
    if (root.val < target) {
      dfs(root.right, target);
    } else {
      dfs(root.left, target);
    }
  }
}
