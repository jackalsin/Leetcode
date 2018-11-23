package _0251_0300._272_Closest_Binary_Search_Tree_Value_II;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/1/2017.
 */
public final class TwoStackOptimalSolution implements Solution {
  public List<Integer> closestKValues(TreeNode root, double target, int k) {
    final Deque<TreeNode> preStack = getPreStack(root, target),
        postStack = getPostStack(root, target);
    final List<Integer> result = new ArrayList<>();
    while (k-- > 0) {
      final Integer left = preStack.isEmpty() ? null : preStack.peek().val,
          right = postStack.isEmpty() ? null : postStack.peek().val;
      if (left != null && right != null) {
        if (Math.abs(target - left) > Math.abs(target - right)) {
          result.add(right);
          nextPost(postStack);
        } else {
          result.add(left);
          nextPre(preStack);
        } // end of both not null
      } else if (left != null) {
        result.add(left);
        nextPre(preStack);
      } else if (right != null) {
        result.add(right);
        nextPost(postStack);
      }
    }
    return result;
  }

  /**
   * @param stack
   * @return
   */
  private static void nextPost(Deque<TreeNode> stack) {
    TreeNode root = stack.pop();
    root = root.right;
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
  }

  /**
   * @param stack
   */
  private static void nextPre(Deque<TreeNode> stack) {
    TreeNode root = stack.pop();
    root = root.left;
    while (root != null) {
      stack.push(root);
      root = root.right;
    }
  }

  /**
   * <= <tt>target</tt>
   *
   * @param root
   * @param target
   * @return
   */
  private static Deque<TreeNode> getPostStack(TreeNode root, double target) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    while (root != null) {
      if (root.val < target) {
        root = root.right;
      } else {
        stack.push(root);
        root = root.left;
      }
    }
    return stack;
  }

  /**
   * @param root
   * @param target
   * @return
   */
  private static Deque<TreeNode> getPreStack(TreeNode root, double target) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    while (root != null) {
      if (root.val >= target) {
        root = root.left;
      } else {
        stack.push(root);
        root = root.right;
      }
    }
    return stack;
  }
}
