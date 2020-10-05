package microsoft.noodleEssence._141_Linked_List_Cycle;

import definition.ListNode;

public class Solution {
  public boolean hasCycle(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (fast == slow) {
        return true;
      }
    }
    return false;
  }
}
