package byteDance._206_Reverse_Linked_List;

import definition.ListNode;

/**
 * @author jacka
 * @version 1.0 on 5/7/2020
 */
public final class SolutionI implements Solution {
  @Override
  public ListNode reverseList(ListNode head) {
    if (head == null) return null;
    final ListNode dummy = new ListNode(1);
    dummy.next = head;
    while (head.next != null) {
      final ListNode toInsert = head.next,
          next = dummy.next;
      head.next = head.next.next;
      dummy.next = toInsert;
      toInsert.next = next;
    }
    return dummy.next;
  }
}
