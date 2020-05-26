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
public final class SolutionI implements Solution {

  /**
   * @param root
   * @param target
   * @param k
   * @return
   */
  @Override
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
      } else if (preStack.isEmpty()) {
        result.add(postStack.peek().val);
        nextPost(postStack);
      } else {
        result.add(preStack.peek().val);
        nextPre(preStack);
      }
    }

    return result;
  }

  private static void nextPre(final Deque<TreeNode> stack) {
    assert !stack.isEmpty();
    TreeNode cur = stack.pop();
    cur = cur.left;
    while (cur != null) {
      stack.push(cur);
      cur = cur.right;
    }
  }

  private static void nextPost(final Deque<TreeNode> stack) {
    assert !stack.isEmpty();
    TreeNode cur = stack.pop();
    cur = cur.right;
    while (cur != null) {
      stack.push(cur);
      cur = cur.left;
    }
  }

  /**
   * <code> <= target </code>
   *
   * @param stack
   * @param root
   * @param target
   */
  private static void initPreStack(final Deque<TreeNode> stack, TreeNode root, double target) {
    while (root != null) {
      if (root.val <= target) {
        stack.push(root);
        root = root.right;
      } else {
        root = root.left;
      }
    }
  }

  /**
   * <code> > target </code>
   *
   * @param stack
   * @param root
   * @param target
   */
  private static void initPostStack(final Deque<TreeNode> stack, TreeNode root, double target) {
    while (root != null) {
      if (root.val <= target) {
        root = root.right;
      } else {
        stack.push(root);
        root = root.left;
      }
    }
  }
}
