package linkedin._141_Linked_List_Cycle;

import definition.ListNode;

/**
 * @author jacka
 * @version 1.0 on 8/9/2021
 */
public final class SolutionIV implements Solution {
  @Override
  public boolean hasCycle(ListNode head) {
    if (head == null) return false;
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (slow == fast) return true;
    }
    return false;
  }
}
