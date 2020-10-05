package airbnb._160_Intersection_of_Two_Linked_Lists;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 1/27/2019.
 */
public final class BothMove implements Solution {
  @Override
  public ListNode getIntersectionNode(final ListNode headA, final ListNode headB) {
    ListNode curA = headA, curB = headB;

    while (true) {
      if (curA == curB) {
        return curA;
      }
      if (curA == null) {
        curA = headB;
      } else {
        curA = curA.next;
      }
      if (curB == null) {
        curB = headA;
      } else {
        curB = curB.next;
      }
    }
  }
}
