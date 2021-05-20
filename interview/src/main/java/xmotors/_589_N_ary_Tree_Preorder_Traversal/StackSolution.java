package xmotors._589_N_ary_Tree_Preorder_Traversal;

import definition.nAryTree.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 5/19/2021
 */
public final class StackSolution implements Solution {
  @Override
  public List<Integer> preorder(Node root) {
    if (root == null) return Collections.emptyList();
    final List<Integer> result = new ArrayList<>();
    final Deque<Node> stack = new ArrayDeque<>();
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        result.add(root.val);
        if (root.children == null || root.children.isEmpty()) {
          root = null;
        } else {
          for (int i = root.children.size() - 1; i > 0; --i) stack.push(root.children.get(i));
          root = root.children.get(0);
        }
      } else {
        root = stack.pop();
      }
    }
    return result;
  }
}
