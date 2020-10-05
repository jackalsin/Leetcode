package hulu._814_Binary_Tree_Pruning;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 2/10/2020
 */
public final class SolutionII implements Solution {
  @Override
  public TreeNode pruneTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    root.left = pruneTree(root.left);
    root.right = pruneTree(root.right);
    if (root.left == null && root.right == null && root.val == 0) {
      return null;
    }
    return root;
  }
}
