package linkedin._156_Binary_Tree_Upside_Down;

import definition.binaryTree.TreeNode;

public class SolutionV implements Solution {
  @Override
  public TreeNode upsideDownBinaryTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    if (root.left == null) {
      return root;
    }
    final TreeNode newRoot = upsideDownBinaryTree(root.left),
        left = root.left, right = root.right;
    root.left = null;
    root.right = null;
    left.left = right;
    left.right = root;
    return newRoot;
  }
}
