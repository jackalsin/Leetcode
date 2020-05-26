package interviews.linkedin._226_Invert_Binary_Tree;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 8/6/2019
 */
public final class SolutionI implements Solution {
  @Override
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
