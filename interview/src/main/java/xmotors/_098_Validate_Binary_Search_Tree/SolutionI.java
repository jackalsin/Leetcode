package xmotors._098_Validate_Binary_Search_Tree;

import definition.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 5/19/2021
 */
public final class SolutionI implements Solution {
  @Override
  public boolean isValidBST(TreeNode root) {
    if (root == null) return false;
    Long prev = null;
    final Deque<TreeNode> stack = new ArrayDeque<>();
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        root = stack.pop();
        if (prev != null && prev >= root.val) return false;
        prev = (long) root.val;
        root = root.right;
      }
    }
    return true;
  }
}
