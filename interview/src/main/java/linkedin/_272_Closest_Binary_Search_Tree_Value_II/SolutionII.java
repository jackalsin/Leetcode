package linkedin._272_Closest_Binary_Search_Tree_Value_II;

import definition.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/20/18
 */
public final class SolutionII implements Solution {
  /**
   *
   * @param root
   * @param target
   * @param k
   * @return
   */
  public List<Integer> closestKValues(TreeNode root, double target, int k) {
    final Deque<TreeNode> preStack = new ArrayDeque<>(), postStack = new ArrayDeque<>();

    initPreStack(preStack, root, target);
    initPostStack(postStack, root, target);

    final List<Integer> result = new ArrayList<>();

    while (k-- > 0) {
      if (!preStack.isEmpty() && !postStack.isEmpty()) {
        if (target - preStack.peek().val > postStack.peek().val - target) {
          result.add(postStack.peek().val);
          nextPost(postStack);
        } else {
          result.add(preStack.peek().val);
          nextPre(preStack);
        }
      } else if (preStack.isEmpty() && !postStack.isEmpty()) {
        result.add(postStack.peek().val);
        nextPost(postStack);
      } else if (postStack.isEmpty() && !preStack.isEmpty()) {
        result.add(preStack.peek().val);
        nextPre(preStack);
      }
    }
    return result;
  }

  private void nextPost(Deque<TreeNode> stack) {
    TreeNode root = stack.pop();
    root = root.right;
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
  }

  private void nextPre(Deque<TreeNode> stack) {
    TreeNode root = stack.pop();
    root = root.left;
    while (root != null) {
      stack.push(root);
      root = root.right;
    }
  }

  private void initPostStack(Deque<TreeNode> stack, TreeNode root, double target) {
    while (root != null) {
      if (root.val <= target) {
        root = root.right;
      } else {
        stack.push(root);
        root = root.left;
      }
    }
  }

  // == ??
  private void initPreStack(Deque<TreeNode> stack, TreeNode root, double target) {
    while (root != null) {
      if (root.val > target) {
        root = root.left;
      } else {
        stack.push(root);
        root = root.right;
      }
    }
  }

}
