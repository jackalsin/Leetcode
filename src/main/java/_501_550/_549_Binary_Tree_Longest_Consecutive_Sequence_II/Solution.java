package _501_550._549_Binary_Tree_Longest_Consecutive_Sequence_II;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 9/10/2017.
 */
public class Solution {
  private int maxVal = 0;

  public int longestConsecutive(TreeNode root) {
    longestPath(root);
    return maxVal;
  }

  /**
   * Increase: from root to leaf
   * return <code>[increasePath, decreasePath]</code>
   *
   * @param root
   * @return
   */
  private int[] longestPath(TreeNode root) {
    if (root == null) {
      return new int[]{0, 0};
    }
    int increasePath = 1, decreasePath = 1;
    if (root.left != null) {
      final int[] leftPath = longestPath(root.left);
      if (root.left.val == root.val + 1) {
        increasePath = leftPath[0] + 1;
      }
      if (root.left.val == root.val - 1) {
        decreasePath = leftPath[1] + 1;
      }
    }

    if (root.right != null) {
      final int[] rightPath = longestPath(root.right);
      if (root.right.val == root.val + 1) {
        increasePath = Math.max(rightPath[0] + 1, increasePath);
      }
      if (root.right.val == root.val - 1) {
        decreasePath = Math.max(rightPath[1] + 1, decreasePath);
      }
    }
//    System.out.println("val = " + root.val + " inc = " + increasePath + " dec = " + decreasePath);
    maxVal = Math.max(maxVal, increasePath + decreasePath - 1);

    return new int[]{increasePath, decreasePath};
  }
}
