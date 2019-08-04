package interviews.linkedin._098_Validate_Binary_Search_Tree;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 8/3/2019
 */
public final class SolutionII implements Solution {
  @Override
  public boolean isValidBST(final TreeNode root) {
    if (root == null) {
      return true;
    }
    final Deque<TreeNode> stack = new ArrayDeque<>();
    long prev = Long.MIN_VALUE;
    TreeNode cur = root;
    while (cur != null || !stack.isEmpty()) {
      if (cur != null) {
        stack.push(cur);
        cur = cur.left;
      } else {
        assert !stack.isEmpty();
        cur = stack.pop();
        if (cur.val <= prev) {
          return false;
        }
        prev = cur.val;
        cur = cur.right;
      }
    }
    return true;
  }
}
