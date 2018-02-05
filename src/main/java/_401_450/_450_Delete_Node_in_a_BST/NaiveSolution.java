package _401_450._450_Delete_Node_in_a_BST;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 2/4/2018.
 */
public class NaiveSolution implements Solution {
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return null;
    }
    if (root.val == key) {
      if (root.right == null) {
        return root.left;
      } else {
        final TreeNode newRoot = root.right;
        TreeNode leftMost = newRoot;
        while (leftMost.left != null) {
          leftMost = leftMost.left;
        }
        leftMost.left = root.left;
        return newRoot;
      }

    } else if (root.val < key) {
      root.right = deleteNode(root.right, key);
    } else {
      root.left = deleteNode(root.left, key);
    }
    return root;
  }
}
