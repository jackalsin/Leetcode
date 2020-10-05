package _0401_0450._430_Flatten_a_Multilevel_Doubly_Linked_List;

import utils._430_Flatten_a_Multilevel_Doubly_Linked_List.Node;

/**
 * @author jacka
 * @version 1.0 on 4/3/2020
 */
public final class SolutionI implements Solution {
  @Override
  public Node flatten(final Node head) {
    if (head == null) {
      return null;
    }
    flattenHelper(head);
    return head;
  }

  /**
   * @return tail
   */
  private Node flattenHelper(final Node head) {
    if (head == null) {
      return null;
    }
    Node prev = null, cur = head, next = cur.next;
    while (cur != null) {
      if (cur.child != null) {
        connect(cur, cur.child);
        final Node curTail = flattenHelper(cur.child);
        cur.child = null;
        connect(curTail, next);
        prev = curTail;
      } else {
        prev = cur;
      }
      cur = next;
      if (cur != null) {
        next = next.next;
      }
    }
    return prev;
  }

  private static void connect(final Node prev, final Node cur) {
    prev.next = cur;
    if (cur != null) {
      cur.prev = prev;
    }
  }
}
