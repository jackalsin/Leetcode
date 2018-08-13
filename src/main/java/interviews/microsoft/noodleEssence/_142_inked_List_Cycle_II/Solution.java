package interviews.microsoft.noodleEssence._142_inked_List_Cycle_II;

import utils.ListNode;

public class Solution {
  public ListNode detectCycle(ListNode head) {
    ListNode slow = head, fast = head;
    boolean hasCycle = false;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (fast == slow) {
        hasCycle = true;
        break;
      }
    }
    if (!hasCycle) {
      return null;
    }
    ListNode entry = head;
    while (slow != entry) {
      slow = slow.next;
      entry = entry.next;
    }
    return entry;
  }
}
