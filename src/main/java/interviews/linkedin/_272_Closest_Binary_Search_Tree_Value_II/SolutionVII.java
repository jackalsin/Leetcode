package interviews.linkedin._272_Closest_Binary_Search_Tree_Value_II;

import utils.binaryTree.TreeNode;

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
    final Deque<TreeNode> prevStack = getPrevStack(root, target),
        postStack = getPostStack(root, target);
    while ((!prevStack.isEmpty() || !postStack.isEmpty()) && result.size() < k) {
      if (!prevStack.isEmpty() && !postStack.isEmpty()) {
        if (target - prevStack.peek().val < postStack.peek().val - target) {
          result.add(prevStack.peek().val);
          nextPrevStack(prevStack);
        } else {
          result.add(postStack.peek().val);
          nextPostStack(postStack);
        }
      } else if (prevStack.isEmpty()) {
        result.add(postStack.peek().val);
        nextPostStack(postStack);
      } else {
        result.add(prevStack.peek().val);
        nextPrevStack(prevStack);
      }
    }
    return result;
  }

  private static void nextPostStack(final Deque<TreeNode> stack) {
    assert !stack.isEmpty();
    final TreeNode toRemove = stack.pop();
    TreeNode cur = toRemove.right;
    while (cur != null) {
      stack.push(cur);
      cur = cur.left;
    }
  }

  private static void nextPrevStack(final Deque<TreeNode> stack) {
    assert !stack.isEmpty();
    final TreeNode toRemove = stack.pop();
    TreeNode cur = toRemove.left;
    while (cur != null) {
      stack.push(cur);
      cur = cur.right;
    }
  }

  /**
   * root.val <= target
   *
   * @param root
   * @param target
   * @return
   */
  private Deque<TreeNode> getPrevStack(final TreeNode root, final double target) {
    final Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode cur = root;
    while (cur != null) {
      if (cur.val <= target) {
        stack.push(cur);
        cur = cur.right;
      } else {
        cur = cur.left;
      }
    }
    return stack;
  }

  private Deque<TreeNode> getPostStack(final TreeNode root, final double target) {
    final Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode cur = root;
    while (cur != null) {
      if (cur.val > target) {
        stack.push(cur);
        cur = cur.left;
      } else {
        cur = cur.right;
      }
    }
    return stack;
  }
}
