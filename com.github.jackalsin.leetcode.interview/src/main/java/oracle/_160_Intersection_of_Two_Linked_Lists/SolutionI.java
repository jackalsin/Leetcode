package oracle._160_Intersection_of_Two_Linked_Lists;

import definition.ListNode;

/**
 * @author jacka
 * @version 1.0 on 10/18/2019
 */
public final class SolutionI implements Solution {
  @Override
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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
