package linkedin._450_Delete_Node_in_a_BST;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 8/14/2019
 */
public final class SwapSolution implements Solution {

  public TreeNode deleteNode(final TreeNode root, int key) {
    if (root == null) {
      return null;
    }
    if (root.val == key) {
      if (root.left == null && root.right == null) {
        return null;
      } else if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      } else {
        final TreeNode minNode = finMin(root.right);
        root.val = minNode.val;
        root.right = deleteNode(root.right, root.val);
        return root;
      }
    } else {
      if (root.val < key) {
        root.right = deleteNode(root.right, key);
      } else {
        root.left = deleteNode(root.left, key);
      }
      return root;
    }
  }

  private static TreeNode finMin(TreeNode root) {
    while (root.left != null) {
      root = root.left;
    }
    return root;
  }
}
