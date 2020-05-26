package _0551_0600._590_N_ary_Tree_Postorder_Traversal;

import utils.nAryTree.Node;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/1/2020
 */
public final class SolutionI implements Solution {
  @Override
  public List<Integer> postorder(Node root) {
    final LinkedList<Integer> result = new LinkedList<>();
    if (root == null) return result;
    final Deque<Node> stack = new ArrayDeque<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      final Node toRemove = stack.pop();
      if (toRemove.children != null) {
        for (final Node node : toRemove.children) {
          stack.push(node);
        }
      }
      result.addFirst(toRemove.val);
    }
    return result;
  }
}
