package interviews.linkedin._156_Binary_Tree_Upside_Down;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 10/21/2017.
 */
public final class SolutionIII implements Solution {
  public TreeNode upsideDownBinaryTree(TreeNode root) {
    if (root == null || root.left == null) {
      return root;
    }

    final TreeNode left = root.left, right = root.right;
    final TreeNode newRoot = upsideDownBinaryTree(root.left);
    left.left = right;
    root.right = null;
    root.left = null;
    left.right = root;
    return newRoot;
  }
}
