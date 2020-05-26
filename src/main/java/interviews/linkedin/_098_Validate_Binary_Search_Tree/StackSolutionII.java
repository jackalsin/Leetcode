package interviews.linkedin._098_Validate_Binary_Search_Tree;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public final class StackSolutionII implements Solution {
  @Override
  public boolean isValidBST(TreeNode root) {
    TreeNode prev = null;
    final Deque<TreeNode> stack = new ArrayDeque<>();
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        root = stack.pop();
        if (prev != null) {
          if (prev.val >= root.val) {
            return false;
          }
        }
        prev = root;
        root = root.right;
      }
    }
    return true;
  }
}
