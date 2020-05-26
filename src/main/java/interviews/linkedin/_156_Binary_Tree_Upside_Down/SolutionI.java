package interviews.linkedin._156_Binary_Tree_Upside_Down;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 10/21/2017.
 */
public final class SolutionI implements Solution {
  public TreeNode upsideDownBinaryTree(TreeNode root) {
    if (root == null || root.left == null) {
      return root;
    }
    TreeNode newRoot = upsideDownBinaryTree(root.left);
    root.left.left = root.right;
    root.left.right = root;
    root.left = null;
    root.right = null;
    return newRoot;
  }
}
