package byteDance._160_Intersection_of_Two_Linked_Lists;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 5/7/2020
 */
public final class SolutionI implements Solution {
  @Override
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode itr1 = headA, itr2 = headB;
    while (itr1 != itr2) {
      if (itr1 == null) {
        itr1 = headB;
      } else {
        itr1 = itr1.next;
      }
      if (itr2 == null) {
        itr2 = headA;
      } else {
        itr2 = itr2.next;
      }
    }
    return itr1;
  }
}
