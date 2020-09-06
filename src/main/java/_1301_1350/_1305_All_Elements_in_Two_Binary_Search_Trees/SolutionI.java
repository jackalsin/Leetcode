package _1301_1350._1305_All_Elements_in_Two_Binary_Search_Trees;

import utils.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/5/2020
 */
public final class SolutionI implements Solution {
  @Override
  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    final var itr1 = new Iterator(root1);
    final var itr2 = new Iterator(root2);
    final List<Integer> result = new ArrayList<>();
    while (itr1.hasNext() || itr2.hasNext()) {
      final long left = itr1.hasNext() ? itr1.peek().val : Long.MAX_VALUE,
          right = itr2.hasNext() ? itr2.peek().val : Long.MAX_VALUE;
      if (left < right) {
        result.add(itr1.next().val);
      } else {
        result.add(itr2.next().val);
      }
    }
    return result;
  }

  private static final class Iterator {
    private final Deque<TreeNode> stack = new ArrayDeque<>();

    private Iterator(TreeNode root) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
    }

    private boolean hasNext() {
      return !stack.isEmpty();
    }

    private TreeNode peek() {
      assert !stack.isEmpty();
      return stack.peek();
    }

    private TreeNode next() {
      final TreeNode result = stack.pop();
      TreeNode root = result.right;
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      return result;
    }
  }
}
