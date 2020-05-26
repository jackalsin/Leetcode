package _1351_1400._1372_Longest_ZigZag_Path_in_a_Binary_Tree;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 4/22/2020
 */
public final class SolutionI implements Solution {

  public int longestZigZag(TreeNode root) {
    return longestZigZagHelper(root)[2];
  }

  private int[] longestZigZagHelper(final TreeNode root) {
    if (root == null) {
      return new int[]{-1, -1, -1};
    }
    final int[] left = longestZigZagHelper(root.left), right = longestZigZagHelper(root.right);
    int res = Math.max(Math.max(left[1], right[0]) + 1, Math.max(left[2], right[2]));
    return new int[]{
        left[1] + 1,
        right[0] + 1,
        res
    };
  }
}
