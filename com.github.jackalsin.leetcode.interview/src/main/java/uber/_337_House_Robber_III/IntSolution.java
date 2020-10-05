package uber._337_House_Robber_III;

import utils.binaryTree.TreeNode;

public class IntSolution implements Solution {
  /**
   * 124 / 124 test cases passed.
   * Status: Accepted
   * Runtime: 3 ms
   * Time complexity: O(N)
   *
   * @param root
   * @return
   */
  @Override
  public int rob(TreeNode root) {
    final int[] res = robHelper(root);
    return Math.max(res[1], res[0]);
  }

  /**
   * Return the result of robber
   *
   * @param root
   * @return an array of int,
   * array[0] is the result that contains root
   * array[1] is the result that doesn't contain root
   */
  private int[] robHelper(final TreeNode root) {
    final int[] res = new int[2];
    if (root == null) {
      return res;
    }

    final int[] left = robHelper(root.left), right = robHelper(root.right);
    res[0] = root.val + left[1] + right[1];
    res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

    return res;
  }
}
