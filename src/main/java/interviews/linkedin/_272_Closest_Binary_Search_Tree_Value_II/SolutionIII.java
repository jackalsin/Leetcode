package interviews.linkedin._272_Closest_Binary_Search_Tree_Value_II;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/20/18
 */
public final class SolutionIII implements Solution {
  /**
   * @param root
   * @param target
   * @param k
   * @return
   */
  public List<Integer> closestKValues(TreeNode root, double target, int k) {
    final Deque<TreeNode> preStack = initPreStack(root, target), postStack = initPostStack(root, target);
    final List<Integer> result = new ArrayList<>();
    for (int i = 0; i < k; ++i) {
      if (!preStack.isEmpty() && !postStack.isEmpty()) {
        if (-preStack.peek().val + target < -target + postStack.peek().val) {
          result.add(preStack.peek().val);
          nextPreStack(preStack);
        } else {
          result.add(postStack.peek().val);
          nextPostStack(postStack);
        }
      } else if (preStack.isEmpty() && !postStack.isEmpty()) {
        result.add(postStack.peek().val);
        nextPostStack(postStack);
      } else if (postStack.isEmpty() && !preStack.isEmpty()) {
        result.add(preStack.peek().val);
        nextPreStack(preStack);
      } else {
        break;
      }
    }
    return result;
  }

  private void nextPostStack(final Deque<TreeNode> stack) {
    TreeNode root = stack.pop();
    root = root.right;
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
  }

  private void nextPreStack(final Deque<TreeNode> stack) {
    TreeNode root = stack.pop();
    root = root.left;
    while (root != null) {
      stack.push(root);
      root = root.right;
    }
  }

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
