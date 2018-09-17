package interviews.linkedin._450_Delete_Node_in_a_BST;

import utils.TreeNode;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/14/18
 */
public class Solution {
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return null;
    }
    if (root.val == key) {
      if (root.left != null) {
        TreeNode cur = root.left;
        while (cur.right != null) {
          cur = cur.right;
        }
        cur.right = root.right;
        return root.left;
      } else {
        return root.right;
      }
    } // end of root.val == key;

    if (root.val < key) {
      root.right = deleteNode(root.right, key);
    } else {
      root.left = deleteNode(root.left, key);
    }
    return root;
  }
}
