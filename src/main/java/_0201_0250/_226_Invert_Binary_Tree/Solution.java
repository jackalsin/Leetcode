package _0201_0250._226_Invert_Binary_Tree;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 8/16/2017.
 */
public class Solution {

  public TreeNode invertTree(TreeNode root) {
    if (root != null) {
      TreeNode left = invertTree(root.left);
      root.left = invertTree(root.right);
      root.right = left;
    }
    return root;
  }
}
