package _0201_0250._222_Count_Complete_Tree_Nodes;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 8/15/2017.
 */
public class Solution {

  public int countNodes(TreeNode root) {
    int height = height(root);
    if (height == 0) {
      return 0;
    }
    if (height(root.right) == height - 1) { // the last level node dies in the right
      return (1 << (height - 1)) + countNodes(root.right);
    } else {
      return (1 << (height - 2)) + countNodes(root.left);
    }
  }

  static int height(TreeNode root) {
    return root == null ? 0 : 1 + height(root.left);
  }
}
