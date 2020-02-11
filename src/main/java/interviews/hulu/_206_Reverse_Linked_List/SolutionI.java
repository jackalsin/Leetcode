package interviews.hulu._206_Reverse_Linked_List;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 2/11/2020
 */
public final class SolutionI implements Solution {
  @Override
  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }
    final ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode tail = head;
    while (tail.next != null) {
      final ListNode toRemove = tail.next;
      tail.next = toRemove.next;
      final ListNode after = dummy.next;
      dummy.next = toRemove;
      toRemove.next = after;
    }
    return dummy.next;
  }
}
