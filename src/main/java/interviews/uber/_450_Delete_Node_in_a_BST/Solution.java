package interviews.uber._450_Delete_Node_in_a_BST;

import utils.TreeNode;

public class Solution {
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return null;
    }
    if (root.val > key) {
      root.left = deleteNode(root.left, key);
    } else if (root.val < key) {
      root.right = deleteNode(root.right, key);
    } else {
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      } else {
        TreeNode minTreeNode = findMin(root.right);
        root.val = minTreeNode.val;
        root.right = deleteNode(root.right, root.val);
      }
    }
    return root;
  }

  /**
   * Return the min node in binary tree
   *
   * @param root
   * @return
   */
  private TreeNode findMin(TreeNode root) {
    TreeNode curNode = root;
    while (root.left != null) {
      root = root.left;
    }
    return root;
  }
}
