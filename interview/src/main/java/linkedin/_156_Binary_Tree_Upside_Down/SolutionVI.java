package linkedin._156_Binary_Tree_Upside_Down;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 8/28/2019
 */
public final class SolutionVI implements Solution {
  @Override
  public TreeNode upsideDownBinaryTree(TreeNode root) {
    if (root == null || root.left == null) return root;
    final TreeNode left = root.left,
        right = root.right;
    root.left = null;
    root.right = null;

    final TreeNode newRoot = upsideDownBinaryTree(left);
    left.left = right;
    left.right = root;
    return newRoot;
  }
}
