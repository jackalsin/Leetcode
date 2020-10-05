package linkedin._450_Delete_Node_in_a_BST;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 9/8/2019
 */
public final class DirectInsertSolutionI implements Solution {
  @Override
  public TreeNode deleteNode(TreeNode root, int key) {
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
        TreeNode cur = root.right;
        assert cur != null;
        while (cur.left != null) {
          cur = cur.left;
        }
        cur.left = root.left;
        return root.right;
      }
    }

    if (root.val < key) {
      root.right = deleteNode(root.right, key);
    } else {
      root.left = deleteNode(root.left, key);
    }
    return root;
  }
}
