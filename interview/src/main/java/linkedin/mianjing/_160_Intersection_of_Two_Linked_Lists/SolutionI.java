package linkedin.mianjing._160_Intersection_of_Two_Linked_Lists;

import definition.ListNode;

public final class SolutionI implements Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode a = headA, b = headB;
    while (true) {
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
