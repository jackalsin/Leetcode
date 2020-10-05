package _0101_0150._104_Maximum_Depth_of_Binary_Tree;

import definition.binaryTree.TreeNode;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/16/2017.
 */
public class Solution {
  public int maxDepth(TreeNode root) {
    return maxTreeHight(root);
  }

  private static int maxTreeHight(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      return Math.max(maxTreeHight(root.left), maxTreeHight(root.right)) + 1;
    }
  }
}
