package linkedin._142_Linked_List_Cycle_II;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 7/4/2019
 */
public final class SolutionI implements Solution {
  @Override
  public ListNode detectCycle(final ListNode head) {
    ListNode slow = head, fast = head, result = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (slow == fast) {
        while (result != slow) {
          slow = slow.next;
          result = result.next;
        }
        return result;
      }
    }
    return null; // no cycle
  }
}
