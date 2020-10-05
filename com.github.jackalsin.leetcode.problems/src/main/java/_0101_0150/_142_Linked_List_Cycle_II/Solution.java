package _0101_0150._142_Linked_List_Cycle_II;

import definition.ListNode;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public class Solution {
  /**
   * Explanation: https://discuss.leetcode.com/topic/5284/concise-o-n-solution-by-using-c-with-detailed-alogrithm-description
   *
   * the total distance of the slow pointer traveled when encounter is L1 + L2
   * the total distance of the fast pointer traveled when encounter is L1 + L2 + n * C
   * Because the total distance the fast pointer traveled is twice as the slow pointer, Thus:
   * 2 * (L1+L2) = L1 + L2 + n * C => L1 + L2 = n * C => L1 = (n - 1) C + (C - L2)
   * It can be concluded that the distance between the head location and entry location is equal to
   * the distance between the meeting location and the entry location along the direction of
   * forward movement.
   *
   * So, when the slow pointer and the fast pointer encounter in the cycle, we can define a
   * pointer "entry" that point to the head, this "entry" pointer moves one step each time so as
   * the slow pointer. When this "entry" pointer and the slow pointer both point to the same
   * location, this location is the node where the cycle begins.
   * @param head
   * @return
   */
  public ListNode detectCycle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    ListNode begin = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        while (begin != slow) {
          slow = slow.next;
          begin = begin.next;
        }
        return begin;
      }
    }
    return null;
  }
}
