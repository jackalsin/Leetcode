package interviews.linkedin._156_Binary_Tree_Upside_Down;

import utils.binaryTree.TreeNode;

public class SolutionIV implements Solution {
  @Override
  public TreeNode upsideDownBinaryTree(TreeNode root) {
    if (root == null) {
      return null;
    } else if (root.left == null) {
      return root;
    }

    final TreeNode left = root.left, right = root.right;
    final TreeNode newRoot = upsideDownBinaryTree(root.left);
    root.left = null;
    root.right = null;
    left.left = right;
    left.right = root;
    return newRoot;
  }
}
