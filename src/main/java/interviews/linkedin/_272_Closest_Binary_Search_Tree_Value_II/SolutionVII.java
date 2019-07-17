package interviews.linkedin._272_Closest_Binary_Search_Tree_Value_II;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 7/16/2019
 */
public final class SolutionVII implements Solution {
  @Override
  public List<Integer> closestKValues(TreeNode root, double target, int k) {
    final List<Integer> result = new ArrayList<>();
    if (root == null || k <= 0) {
      return result;
    }
    final Deque<TreeNode> preStack = initPreStack(root, target),
        postStack = initPostStack(root, target);
    for (int i = 0; i < k; i++) {
      if (preStack.isEmpty() && postStack.isEmpty()) {
        break;
      } else if (preStack.isEmpty()) {
        result.add(postStack.peek().val);
        nextPost(postStack);
      } else if (postStack.isEmpty()) {
        result.add(preStack.peek().val);
        nextPre(preStack);
      } else {
        if (target - preStack.peek().val < postStack.peek().val - target) {
          result.add(preStack.peek().val);
          nextPre(preStack);
        } else {
          result.add(postStack.peek().val);
          nextPost(postStack);
        }
      }
    }
    return result;
  }

  private static void nextPre(final Deque<TreeNode> stack) {
    TreeNode cur = stack.pop();
    cur = cur.left;
    while (cur != null) {
      stack.push(cur);
      cur = cur.right;
    }
  }

  private static void nextPost(final Deque<TreeNode> stack) {
    TreeNode cur = stack.pop();
    cur = cur.right;
    while (cur != null) {
      stack.push(cur);
      cur = cur.left;
    }
  }

  /**
   * <= target
   *
   * @param root
   * @param target
   * @return
   */
  private static Deque<TreeNode> initPreStack(TreeNode root, final double target) {
    final Deque<TreeNode> stack = new ArrayDeque<>();
    while (root != null) {
      if (root.val <= target) {
        stack.push(root);
        root = root.right;
      } else {
        root = root.left;
      }
    }
    return stack;
  }

  private static Deque<TreeNode> initPostStack(TreeNode root, final double target) {
    final Deque<TreeNode> stack = new ArrayDeque<>();
    while (root != null) {
      if (root.val > target) {
        stack.push(root);
        root = root.left;
      } else {
        root = root.right;
      }
    }
    return stack;
  }
}
