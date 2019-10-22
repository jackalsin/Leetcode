package interviews.oracle._019_Remove_Nth_Node_From_End_of_List;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 10/21/2019
 */
public final class SolutionI implements Solution {
  @Override
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) {
      return null;
    }
    final ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode slow = dummy, fast = head;
    for (int i = 0; i < n; i++) {
      fast = fast.next;
    }
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }
    slow.next = slow.next.next;
    return dummy.next;
  }
}
