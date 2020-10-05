package hulu._337_House_Robber_III;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 12/18/2019
 */
public final class SolutionI implements Solution {

  public int rob(TreeNode root) {
    final int[] res = robHelper(root);
    return Math.max(res[0], res[1]);
  }

  /**
   * @return {rob, noRob}
   */
  private static int[] robHelper(final TreeNode root) {
    if (root == null) {
      return new int[]{0, 0};
    }
    final int[] left = robHelper(root.left),
        right = robHelper(root.right);
    final int rob = root.val + left[1] + right[1],
        noRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    return new int[]{rob, noRob};
  }
}
