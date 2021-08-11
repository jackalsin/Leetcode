package linkedin._337_House_Robber_III;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 8/11/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int rob(TreeNode root) {
    final int[] res = robHelper(root);
    return Math.max(res[0], res[1]);
  }

  /**
   * @return {noRob, rob}
   */
  private static int[] robHelper(final TreeNode root) {
    if (root == null) return new int[]{0, 0};
    final int[] left = robHelper(root.left), right = robHelper(root.right);
    final int rob = left[0] + right[0] + root.val,
        noRob = Math.max(left[1], left[0]) + Math.max(right[0], right[1]);
    return new int[]{noRob, rob};
  }

}
