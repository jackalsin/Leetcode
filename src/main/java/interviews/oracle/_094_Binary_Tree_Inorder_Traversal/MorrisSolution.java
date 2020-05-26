package interviews.oracle._094_Binary_Tree_Inorder_Traversal;

import utils.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhixi
 * @version 1.0 on 11/28/2019
 */
public final class MorrisSolution implements Solution {
  @Override
  public List<Integer> inorderTraversal(final TreeNode root) {
    final List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    TreeNode cur = root;
    while (cur != null) {
      if (cur.left == null) {
        result.add(cur.val);
        cur = cur.right;
      } else {
        TreeNode rightMostNode = cur.left;
        while (rightMostNode.right != null && rightMostNode.right != cur) {
          rightMostNode = rightMostNode.right;
        }
        if (rightMostNode.right == cur) {
          rightMostNode.right = null;
          result.add(cur.val);
          cur = cur.right;
        } else { // rightMostNde.right == null
          rightMostNode.right = cur;
          cur = cur.left;
        }
      }
    }
    return result;
  }
}
