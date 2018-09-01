package interviews.linkedin.mianjing._156_Binary_Tree_Upside_Down;

import utils.TreeNode;

public class Solution {

  public TreeNode upsideDownBinaryTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    if (root.left == null) {
      return root;
    }

    final TreeNode left = root.left, right = root.right,
        newRoot = upsideDownBinaryTree(left);

    root.left = null;
    root.right = null;
    left.left = right;
    left.right = root;

    return newRoot;
  }
}
