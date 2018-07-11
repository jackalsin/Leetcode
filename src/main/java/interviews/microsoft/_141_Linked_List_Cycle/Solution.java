package interviews.microsoft._141_Linked_List_Cycle;

import utils.ListNode;

public class Solution {
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
