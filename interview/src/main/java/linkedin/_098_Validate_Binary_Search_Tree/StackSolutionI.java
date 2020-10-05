package linkedin._098_Validate_Binary_Search_Tree;

import definition.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 8/3/2019
 */
public final class StackSolutionI implements Solution {
  @Override
  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    long preVal = Long.MIN_VALUE;
    final Deque<TreeNode> stack = new ArrayDeque<>();
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        root = stack.pop();
        if (root.val <= preVal) {
          return false;
        }
        preVal = root.val;
        root = root.right;
      }
    }
    return true;
  }
}
