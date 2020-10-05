package linkedin._142_Linked_List_Cycle_II;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 8/27/2019
 */
public final class SolutionII implements Solution {
  @Override
  public ListNode detectCycle(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        ListNode result = head;
        while (result != fast) {
          result = result.next;
          fast = fast.next;
        }
        return result;
      }
    }
    return null;
  }
}
