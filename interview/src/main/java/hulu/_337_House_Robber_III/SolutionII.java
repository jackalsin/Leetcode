package hulu._337_House_Robber_III;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 2/24/2020
 */
public final class SolutionII implements Solution {

  public int rob(TreeNode root) {
    final int[] res = robHelper(root);
    return Math.max(res[0], res[1]);
  }

  /**
   * @param root
   * @return {rob, noRob}
   */
  private static int[] robHelper(final TreeNode root) {
    if (root == null) {
      return new int[]{0, 0};
    }
    int rob = root.val, noRob = 0;
    final int[] left = robHelper(root.left), right = robHelper(root.right);
    return new int[]{rob + left[1] + right[1], Math.max(left[0], left[1]) + Math.max(right[0], right[1])};
  }

}
