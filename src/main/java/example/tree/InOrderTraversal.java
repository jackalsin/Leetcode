package example.tree;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public final class InOrderTraversal implements Traversal {
  @Override
  public List<Integer> traverse(TreeNode root) {
    final List<Integer> result = new ArrayList<>();
    final Deque<TreeNode> stack = new ArrayDeque<>();
    while (!stack.isEmpty() || root != null) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        root = stack.pop();
        result.add(root.val);
        root = root.right;
      }
    }
    return result;
  }
}
