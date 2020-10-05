package linkedin._450_Delete_Node_in_a_BST;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 8/14/2019
 */
public final class DirectInsertSolution implements Solution {
  @Override
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return null;
    }
    if (root.val != key) {
      if (root.val < key) {
        root.right = deleteNode(root.right, key);
      } else {
        root.left = deleteNode(root.left, key);
      }
      return root;
    }
    if (root.left == null) {
      return root.right;
    }
    TreeNode cur = root.left;
    while (cur.right != null) {
      cur = cur.right;
    }
    cur.right = root.right;
    return root.left;
  }
}
