package _151_200._160_Intersection_of_Two_Linked_Lists;

import utils.ListNode;

import java.util.HashSet;
import java.util.Set;

public final class SolutionI implements Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode curA = headA;
    ListNode curB = headB;
    Set<ListNode> visited = new HashSet<>();
    while (curA != null || curB != null) {
      if (curA != null) {
        if (visited.contains(curA)) {
          return curA;
        }
        visited.add(curA);
      }
      if (curB != null) {
        if (visited.contains(curB)) {
          return curB;
        }
        visited.add(curB);
      }
      if (curA != null) curA = curA.next;
      if (curB != null) curB = curB.next;
    }
    return null;
  }
}
