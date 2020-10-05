package linkedin._160_Intersection_of_Two_Linked_Lists;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 8/31/2019
 */
public final class FloydCycleSolution implements Solution {
  @Override
  public ListNode getIntersectionNode(final ListNode headA, final ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    ListNode cur = headA;
    while (cur.next != null) {
      cur = cur.next;
    }
    final ListNode tail = cur;
    cur.next = headA;
    ListNode fast = headB, slow = headB;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (slow == fast) {
        cur = headB;
        while (cur != slow) {
          cur = cur.next;
          slow = slow.next;
        }
        tail.next = null;
        return slow;
      }
    }
    tail.next = null;
    return null;
  }
}
