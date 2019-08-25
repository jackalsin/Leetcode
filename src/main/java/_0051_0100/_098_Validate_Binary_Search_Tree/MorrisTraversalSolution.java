package _0051_0100._098_Validate_Binary_Search_Tree;

import interviews.linkedin._098_Validate_Binary_Search_Tree.Solution;
import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 8/25/2019
 */
public final class MorrisTraversalSolution implements Solution {
  @Override
  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    TreeNode cur = root;
    long preVal = Long.MIN_VALUE;
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
        if (rightMostNode.right == cur) { // 回来的path
          // check
          if (preVal >= cur.val) {
            return false;
          }
          preVal = cur.val;
          // normal move
          cur = cur.right;
          rightMostNode.right = null;
        } else {
          rightMostNode.right = cur;
          cur = cur.left;
        }
      }
    }
    return true;
  }
}
