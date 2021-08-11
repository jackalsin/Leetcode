package linkedin._160_Intersection_of_Two_Linked_Lists;

import definition.ListNode;

public final class FloydCycleSolutionI implements Solution {
  @Override
  public ListNode getIntersectionNode(final ListNode headA, final ListNode headB) {
    if (headA == null) return headB;
    if (headB == null) return headA;
    ListNode cur = headA;
    while (cur.next != null) cur = cur.next;
    cur.next = headA;
    final ListNode tail = cur;
    ListNode slow = headB, fast = headB;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (slow == fast) {
        cur = headB;
        while (cur != slow) {
          slow = slow.next;
          cur = cur.next;
        }

        tail.next = null;
        return slow;
      }
    }
    tail.next = null;
    return null;
  }
}
