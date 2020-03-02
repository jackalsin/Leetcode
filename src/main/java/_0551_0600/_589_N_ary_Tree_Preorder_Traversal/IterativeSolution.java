package _0551_0600._589_N_ary_Tree_Preorder_Traversal;

import utils.treeNode.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/1/2020
 */
public final class IterativeSolution implements Solution {
  @Override
  public List<Integer> preorder(Node root) {
    final List<Integer> result = new ArrayList<>();
    if (root == null) return result;
    final Deque<Node> stack = new ArrayDeque<>();
    while (!stack.isEmpty() || root != null) {
      if (root != null) {
        result.add(root.val);
        if (root.children == null || root.children.isEmpty()) {
          root = null;
        } else {
          final int size = root.children.size();
          for (int i = size - 1; i >= 1; --i) {
            stack.push(root.children.get(i));
          }
          root = root.children.get(0);
        }
      } else {
        root = stack.pop();
      }
    }
    return result;
  }
}
