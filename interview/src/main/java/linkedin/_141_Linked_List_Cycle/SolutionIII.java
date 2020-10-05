package linkedin._141_Linked_List_Cycle;

import definition.ListNode;

/**
 * @author jacka
 * @version 1.0 on 8/27/2019
 */
public final class SolutionIII implements Solution {
  @Override
  public boolean hasCycle(ListNode head) {
    ListNode fast = head, slow = head;
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
