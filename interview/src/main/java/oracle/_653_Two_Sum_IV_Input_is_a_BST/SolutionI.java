package oracle._653_Two_Sum_IV_Input_is_a_BST;

import definition.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 11/4/2019
 */
public final class SolutionI implements Solution {
  @Override
  public boolean findTarget(TreeNode root, int k) {
    final Deque<TreeNode> prevStack = getLeftStack(root),
        postStack = getRightStack(root);
    while (!prevStack.isEmpty() && !postStack.isEmpty()
        && prevStack.peek().val != postStack.peek().val) {
      final long left = prevStack.peek().val, right = postStack.peek().val, sum = left + right;
      if (sum == k) {
        return true;
      } else if (sum < k) {
        nextPrev(prevStack);
      } else {
        nextPost(postStack);
      }
    }
    return false;
  }

  private static void nextPost(Deque<TreeNode> stack) {
    final TreeNode toRemove = stack.pop();
    TreeNode cur = toRemove.left;
    while (cur != null) {
      stack.push(cur);
      cur = cur.right;
    }
  }

  private static void nextPrev(final Deque<TreeNode> stack) {
    final TreeNode toRemove = stack.pop();
    TreeNode cur = toRemove.right;
    while (cur != null) {
      stack.push(cur);
      cur = cur.left;
    }
  }

  private static Deque<TreeNode> getLeftStack(TreeNode root) {
    final Deque<TreeNode> stack = new ArrayDeque<>();
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
    return stack;
  }

  private static Deque<TreeNode> getRightStack(TreeNode root) {
    final Deque<TreeNode> stack = new ArrayDeque<>();
    while (root != null) {
      stack.push(root);
      root = root.right;
    }
    return stack;
  }
}
