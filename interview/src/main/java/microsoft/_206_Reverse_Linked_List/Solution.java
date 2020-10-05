package microsoft._206_Reverse_Linked_List;

import definition.ListNode;

public class Solution {
  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }
    final ListNode dummy = new ListNode(1);
    dummy.next = head;
    ListNode tail = head;
    // find the tail

    while (tail.next != null) {
      tail = tail.next;
    }

    while (dummy.next != tail) {
      ListNode toMove = dummy.next;
      dummy.next = dummy.next.next;

      toMove.next = tail.next;
      tail.next = toMove;
    }
    return dummy.next;
  }
}
