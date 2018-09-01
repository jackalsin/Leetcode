package _151_200._160_Intersection_of_Two_Linked_Lists;

import utils.ListNode;

public final class SolutionII implements Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode a = headA, b = headB;
    while (true) {
      // 需要放在前面，保持 [1] 这样test case 通过
      if (a == b) {
        return a;
      }

      if (a == null) {
        a = headB;
      } else {
        a = a.next;
      }
      if (b == null) {
        b = headA;
      } else {
        b = b.next;
      }
    }
  }
}
