package _1351_1400._1373_Maximum_Sum_BST_in_Binary_Tree;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 4/24/2020
 */
public final class SolutionI implements Solution {
  private int result = 0;

  public int maxSumBST(TreeNode root) {
    maxSumBSTHelper(root);
    return result;
  }

  /**
   * Return null when it's not a BST, otherwise, return {min, max, sum}
   *
   * @param root
   * @return
   */
  private int[] maxSumBSTHelper(final TreeNode root) {
    if (root == null) {
      return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
    }
    final int[] left = maxSumBSTHelper(root.left),
        right = maxSumBSTHelper(root.right);
    if (!(left != null && right != null && left[1] < root.val && root.val < right[0])) {
      return null;
    }
    final int sum = root.val + left[2] + right[2];
    result = Math.max(result, sum);
    return new int[]{Math.min(left[0], root.val), Math.max(right[1], root.val), sum};
  }

}
