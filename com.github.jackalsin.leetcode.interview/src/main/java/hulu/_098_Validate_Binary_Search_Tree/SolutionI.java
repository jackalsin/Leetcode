package hulu._098_Validate_Binary_Search_Tree;

import definition.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 2/11/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean isValidBST(TreeNode root) {
    if (root == null) return true;
    final Deque<TreeNode> stack = new ArrayDeque<>();
    long prev = Long.MIN_VALUE;
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        root = stack.pop();
        if (root.val <= prev) {
          return false;
        }
        prev = root.val;
        root = root.right;
      }
    }
    return true;
  }
}
