package interviews.microsoft._285_Inorder_Successor_in_BST;

import utils.binaryTree.TreeNode;

public class Solution {

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
