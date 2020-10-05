package google._337_House_Robber_III;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 3/12/2018.
 */
public class Solution {
  public int rob(TreeNode root) {
    final int[] res = robHelper(root);
    return Math.max(res[0], res[1]);
  }

  /**
   * @return {maxNotUsingThis, maxUsingThis}
   */
  private int[] robHelper(TreeNode root) {
    if (root == null) {
      return new int[2];
    }

    final int[] left = robHelper(root.left),
        right = robHelper(root.right), res = new int[2];

    res[0] = Math.max(left[0], left[1]) + Math.max(right[1], right[0]);
    res[1] = root.val + left[0] + right[0];
    return res;
  }
}
