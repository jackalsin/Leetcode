package interviews.oracle._098_Validate_Binary_Search_Tree;

import utils.binaryTree.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 11/29/2019
 */
public final class SolutionI implements Solution {
  @Override
  public boolean isValidBST(final TreeNode root) {
    if (root == null) {
      return true;
    }
    long preVal = Long.MIN_VALUE;
    TreeNode cur = root;
    while (cur != null) {
      if (cur.left == null) {
        if (preVal >= cur.val) {
          return false;
        }
        preVal = cur.val;
        cur = cur.right;
      } else {
        TreeNode rightMostNode = cur.left;
        while (rightMostNode.right != null && rightMostNode.right != cur) {
          rightMostNode = rightMostNode.right;
        }
        if (rightMostNode.right == null) {
          rightMostNode.right = cur;
          cur = cur.left;
        } else {
          if (preVal >= cur.val) {
            return false;
          }
          preVal = cur.val;
          cur = cur.right;
          rightMostNode.right = null;
        }
      }
    }
    return true;
  }
}
