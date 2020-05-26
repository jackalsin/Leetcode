package _0401_0450._450_Delete_Node_in_a_BST;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 2/4/2018.
 */
public class BetterSolution implements Solution {

  /**
   * Recursively find the node that has the same value as the key, while setting the left/right
   * nodes equal to the returned subtree
   * Once the node is found, have to handle the below 4 cases
   * node doesn't have left or right - return null
   * node only has left subtree- return the left subtree
   * node only has right subtree- return the right subtree
   * node has both left and right - find the minimum value in the right subtree, set that value
   * to the currently found node, then recursively delete the minimum value in the right subtree
   */
  @Override
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return root;
    }
    if (root.val == key) {
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      } else {
        TreeNode leftMost = root.right;
        while (leftMost.left != null) {
          leftMost = leftMost.left;
        }
        root.val = leftMost.val;
        root.right = deleteNode(root.right, root.val);
      }
    } else if (root.val > key) {
      root.left = deleteNode(root.left, key);
    } else {
      root.right = deleteNode(root.right, key);
    }
    return root;
  }
}
