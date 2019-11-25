package _0101_0150._117_Populating_Next_Right_Pointers_in_Each_Node_II;

import utils.treeLinkNode._117_Populating_Next_Right_Pointers_in_Each_Node_II.Node;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 6/25/2017.
 */
public final class QueueSolution implements Solution {
  public Node connect(Node root) {
    if (root == null) {
      return null;
    }
    final Queue<Node> q = new ArrayDeque<>();
    q.add(root);
    while (!q.isEmpty()) {
      final int size = q.size();
      Node prev = null;
      for (int i = 0; i < size; ++i) {
        final Node cur = q.remove();
        if (cur.left != null) {
          if (prev == null) {
            prev = cur.left;
          } else {
            prev.next = cur.left;
            prev = prev.next;
          }
          q.add(cur.left);
        }
        if (cur.right != null) {
          if (prev == null) {
            prev = cur.right;
          } else {
            prev.next = cur.right;
            prev = prev.next;
          }
          q.add(cur.right);
        } // end of right
      } // end of for
    }
    return root;
  }
}
