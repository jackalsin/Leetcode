package oracle._141_Linked_List_Cycle;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 10/19/2019
 */
public final class SolutionI implements Solution {
  @Override
  public boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }
}
