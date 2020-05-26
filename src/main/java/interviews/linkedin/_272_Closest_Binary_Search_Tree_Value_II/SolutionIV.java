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
public final class SolutionIV implements Solution {
  /**
   * @param root
   * @param target
   * @param k
   * @return
   */
  public List<Integer> closestKValues(TreeNode root, double target, int k) {
    final Deque<TreeNode> preStack = initPreStack(root, target), postStack = initPostStack(root, target);
    final List<Integer> result = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      if (!preStack.isEmpty() && !postStack.isEmpty()) {
        if (target - preStack.peek().val < postStack.peek().val - target) {
          result.add(preStack.peek().val);
          nextPreStack(preStack);
        } else {
          result.add(postStack.peek().val);
          nextPostStack(postStack);
        }
      } else if (!preStack.isEmpty()) {
        result.add(preStack.peek().val);
        nextPreStack(preStack);
      } else if (!postStack.isEmpty()) {
        result.add(postStack.peek().val);
        nextPostStack(postStack);
      }
    }
    return result;
  }

  private static void nextPostStack(Deque<TreeNode> stack) {
    TreeNode root = stack.pop();
    root = root.right;
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
  }

  private static void nextPreStack(final Deque<TreeNode> stack) {
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
      if (root.val > target) {
        root = root.left;
      } else {
        stack.push(root);
        root = root.right;
      }
    }
    return stack;
  }

  private static Deque<TreeNode> initPostStack(TreeNode root, double target) {
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
