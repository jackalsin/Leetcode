package interviews.linkedin._450_Delete_Node_in_a_BST;

import utils.binaryTree.TreeNode;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/14/18
 */
public final class SolutionII implements Solution {
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return null;
    }
    if (root.val == key) {
      TreeNode cur = root.left;
      if (cur == null) {
        return root.right;
      }
      while (cur.right != null) {
        cur = cur.right;
      }
      cur.right = root.right;
      return root.left;
    } else {
      if (root.val < key) {
        root.right = deleteNode(root.right, key);
      } else {
        root.left = deleteNode(root.left, key);
      }
      return root;
    }
  }
}
