package linkedin._226_Invert_Binary_Tree;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 8/31/2019
 */
public final class SolutionII implements Solution {
  @Override
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    final TreeNode left = invertTree(root.left), right = invertTree(root.right);
    root.left = right;
    root.right = left;
    return root;
  }
}
