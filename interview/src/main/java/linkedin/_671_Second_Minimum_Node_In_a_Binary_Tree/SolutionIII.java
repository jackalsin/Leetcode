package linkedin._671_Second_Minimum_Node_In_a_Binary_Tree;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 10/23/2017.
 */
public final class SolutionIII implements Solution {
  private long min = Long.MAX_VALUE, secMin = Long.MAX_VALUE;

  public int findSecondMinimumValue(TreeNode root) {
    if (root == null) {
      return -1;
    }
    min = root.val;
    dfs(root);
    return secMin == Long.MAX_VALUE ? -1 : (int) secMin;
  }

  private void dfs(final TreeNode root) {
    if (root == null) {
      return;
    }

    if (root.val == min) {
      dfs(root.left);
      dfs(root.right);
    } else if (min < root.val && root.val < secMin) {
      secMin = root.val;
    }

  }
}
