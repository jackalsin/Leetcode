package interviews.pureStorage._0203_Remove_Linked_List_Elements;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 10/6/2019
 */
public final class SolutionI implements Solution {
  @Override
  public ListNode removeElements(ListNode head, int val) {
    final ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;
    while (prev.next != null) {
      if (prev.next.val == val) {
        prev.next = prev.next.next;
        continue;
      }
      prev = prev.next;
    }
    return dummy.next;
  }
}
