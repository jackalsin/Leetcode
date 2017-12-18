package _501_550._543_Diameter_of_Binary_Tree;

import utils.TreeNode;

public class Solution {
  private int max = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    longestSinglePath(root);
    return max;
  }

  private int longestSinglePath(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftLongest = longestSinglePath(root.left);
    int rightLongest = longestSinglePath(root.right);
    max = Math.max(max, leftLongest + rightLongest);
    return Math.max(rightLongest, leftLongest) + 1;
  }

}
