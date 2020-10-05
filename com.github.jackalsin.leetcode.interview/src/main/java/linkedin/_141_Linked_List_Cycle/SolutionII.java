package linkedin._141_Linked_List_Cycle;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 8/3/2019
 */
public final class SolutionII implements Solution {
  @Override
  public boolean hasCycle(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        return true;
      }
    }
    return false;
  }
}
