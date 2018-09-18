package interviews.linkedin._226_Invert_Binary_Tree;

import utils.TreeNode;

public class Solution {
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    final TreeNode left = root.left, right = root.right;
    root.left = invertTree(right);
    root.right = invertTree(left);
    return root;
  }

}
