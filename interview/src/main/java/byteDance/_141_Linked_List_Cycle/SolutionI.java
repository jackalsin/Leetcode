package byteDance._141_Linked_List_Cycle;

import definition.ListNode;

/**
 * @author jacka
 * @version 1.0 on 3/21/2021
 */
public final class SolutionI implements Solution {
  @Override
  public boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (true) {
      if (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      } else {
        return false;
      }
      if (slow == fast) {
        return true;
      }
    }
  }
}
