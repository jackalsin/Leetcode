package _0701_0750._708_Insert_into_a_Cyclic_Sorted_List;


import utils._708_Insert_into_a_Sorted_Circular_Linked_List.Node;

/**
 * @author jacka
 * @version 1.0 on 5/17/2020
 */
public final class SolutionI implements Solution {
  @Override
  public Node insert(Node head, int insertVal) {
    final Node toInsert = new Node(insertVal);
    if (head == null) {
      toInsert.next = toInsert;
      return toInsert;
    }
    final Node max = getMax(head);
    if (toInsert.val <= max.next.val || toInsert.val > max.val) {
      append(max, toInsert);
    } else {
      Node cur = max.next;
      while (!(cur.val <= toInsert.val && toInsert.val <= cur.next.val)) {
        cur = cur.next;
      }
      append(cur, toInsert);
    }
    return head;
  }

  private static void append(final Node prev, Node toInsert) {
    final Node next = prev.next;
    prev.next = toInsert;
    toInsert.next = next;
  }

  private static Node getMax(final Node head) {
    Node cur = head;
    while (cur.val <= cur.next.val && head != cur.next) {
      cur = cur.next;
    }
    return cur;
  }
}
