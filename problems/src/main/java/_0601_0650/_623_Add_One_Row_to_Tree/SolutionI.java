package _0601_0650._623_Add_One_Row_to_Tree;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 3/5/2020
 */
public final class SolutionI implements Solution {
  @Override
  public TreeNode addOneRow(TreeNode root, int v, int d) {
    if (d == 1) {
      final TreeNode newRoot = new TreeNode(v);
      newRoot.left = root;
      return newRoot;
    }
    addOneRowHelper(root, v, d - 1);
    return root;
  }

  private void addOneRowHelper(final TreeNode root, int v, int d) {
    if (root == null) {
      return;
    }
    final TreeNode left = root.left, right = root.right;
    if (d == 1) {
      root.left = new TreeNode(v);
      root.right = new TreeNode(v);
      root.left.left = left;
      root.right.right = right;
      return;
    }
    addOneRowHelper(root.left, v, d - 1);
    addOneRowHelper(root.right, v, d - 1);
  }
}
