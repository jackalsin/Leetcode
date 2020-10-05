package microsoft._160_Intersection_of_Two_Linked_Lists;

import definition.ListNode;

public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headB == null || headA == null) {
      return null;
    }
    ListNode tail = headB;
    while (tail.next != null) {
      tail = tail.next;
    }
    tail.next = headB;

    // head
    ListNode slow = headA, fast = headA, entry = headA;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        while (slow != entry) {
          slow = slow.next;
          entry = entry.next;
        }
        tail.next = null;
        return entry;
      }
    }

    // recover
    tail.next = null;
    return null;
  }
}
