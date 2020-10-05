package linkedin._272_Closest_Binary_Search_Tree_Value_II;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 7/16/2019
 */
public final class SolutionVI implements Solution {
  @Override
  public List<Integer> closestKValues(TreeNode root, double target, int k) {
    final Deque<TreeNode> preStack = getPredecessor(root, target),
        postStack = getSuccessor(root, target);

    final List<Integer> result = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      if (preStack.isEmpty() && postStack.isEmpty()) {
        break;
      } else if (preStack.isEmpty()) {
        final int res = nextSuccessor(postStack);
        result.add(res);
      } else if (postStack.isEmpty()) {
        final int res = nextPredecessor(preStack);
        result.add(res);
      } else {
        if (target - preStack.peek().val < postStack.peek().val - target) {
          final int res = nextPredecessor(preStack);
          result.add(res);
        } else {
          final int res = nextSuccessor(postStack);
          result.add(res);
        }
      }
    }
    return result;
  }

  private static int nextPredecessor(final Deque<TreeNode> stack) {
    assert !stack.isEmpty();
    final TreeNode result = stack.pop();
    TreeNode cur = result.left;
    while (cur != null) {
      stack.push(cur);
      cur = cur.right;
    }
    return result.val;
  }

  private static int nextSuccessor(final Deque<TreeNode> stack) {
    assert !stack.isEmpty();
    final TreeNode result = stack.pop();
    TreeNode cur = result.right;
    while (cur != null) {
      stack.push(cur);
      cur = cur.left;
    }
    return result.val;
  }

  private static Deque<TreeNode> getSuccessor(final TreeNode root, final double target) {
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

  /**
   * Contains nodes <= <tt>target</tt>
   *
   * @param root
   * @param target
   * @return
   */
  private static Deque<TreeNode> getPredecessor(final TreeNode root, final double target) {
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
}
