package interviews.facebook._206_Reverse_Linked_List;

import utils.ListNode;

public class Solution {
  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }
    final ListNode dummy = new ListNode(0);
    dummy.next = head;
    // head == null?
    ListNode tail = head;
    while (tail.next != null) {
      tail = tail.next;
    }

    while (dummy.next != tail) {
      final ListNode toRemove = dummy.next;
      dummy.next = toRemove.next;
      toRemove.next = tail.next;
      tail.next = toRemove;
    }
    return dummy.next;
  }
}
