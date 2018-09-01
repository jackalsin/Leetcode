package _151_200._160_Intersection_of_Two_Linked_Lists;

import utils.ListNode;

public final class SolutionIII implements Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    // headB is the cycle end
    ListNode fast = headA, slow = headA;
    if (fast == null) {
      return null;
    }
    while (fast.next != null) {
      fast = fast.next;
    }
    final ListNode tail = fast;
    fast.next = headB;
    fast = headA;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (slow == fast) {
        ListNode start = headA;
        while (start != slow) {
          slow = slow.next;
          start = start.next;
        }
        tail.next = null;
        return start;
      }
    }

    tail.next = null;
    // no cycle;
    return null;

  }
}
