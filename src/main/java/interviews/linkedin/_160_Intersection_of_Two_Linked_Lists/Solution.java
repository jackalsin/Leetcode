package interviews.linkedin._160_Intersection_of_Two_Linked_Lists;

import utils.ListNode;

public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode a = headA, b = headB;
    while (a != b) {
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
    return a;
  }
}
