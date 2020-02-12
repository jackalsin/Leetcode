package interviews.hulu._117_Populating_Next_Right_Pointers_in_Each_Node_II;


import utils.treeLinkNode._117_Populating_Next_Right_Pointers_in_Each_Node_II.Node;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 2/11/2020
 */
public final class SpaceONSolution implements Solution {
  @Override
  public Node connect(Node root) {
    if (root == null) {
      return root;
    }
    final Queue<Node> q = new ArrayDeque<>();
    q.add(root);
    while (!q.isEmpty()) {
      final int size = q.size();
      Node prev = null;
      for (int i = 0; i < size; i++) {
        final Node toRemove = q.remove();
        if (toRemove.left != null) {
          q.add(toRemove.left);
        }
        if (toRemove.right != null) {
          q.add(toRemove.right);
        }
        if (prev != null) {
          prev.next = toRemove;
        }
        prev = toRemove;
      }
    }
    return root;
  }
}
