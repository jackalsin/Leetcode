package _051_100._098_Validate_Binary_Search_Tree;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.TreeNode;

/**
 * @author jacka
 * @version 1.0 on 6/6/2017.
 */
public class Solution {
  public boolean isValidBST(TreeNode root) {
    Deque<TreeNode> parentNodes = new ArrayDeque<>();
    Integer prev = null;
    while (!parentNodes.isEmpty() || root != null) {
      if (root != null) {
        parentNodes.addLast(root);
        root = root.left;
      } else {
        TreeNode curNode = parentNodes.removeLast();
        if (prev == null) {
          prev = curNode.val;
        } else if (prev >= curNode.val) {
          return false;
        }
        prev = curNode.val;
        root = curNode.right;
      }
    }
    return true;
  }
}
