package _0251_0300._285_Inorder_Successor_in_BST;

import definition.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 9/4/2017.
 */
public class Solution {
  /**
   * Given a binary search tree and a node in it, find the in-order successor of that node in the
   * BST.
   * Note: If the given node has no in-order successor in the tree, return null.
   * @param root
   * @param p
   * @return
   */
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    TreeNode successor = null;
    while (root != null) {
      if (root.val <= p.val) {
        root = root.right;
      } else {
        successor = root;
        root = root.left;
      }
    }
    return successor;
  }
}
