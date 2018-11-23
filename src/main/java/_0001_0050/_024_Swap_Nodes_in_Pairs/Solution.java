package _0001_0050._024_Swap_Nodes_in_Pairs;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 2017/1/23.
 */
public class Solution {
  /**
   * Given a linked list, swap every two adjacent nodes and return its head.
   *
   * @param head a list to swap
   * @return a swapped list
   */
  public ListNode swapPairs(ListNode head) {
    if (head == null) {
      return null;
    } else {
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode prev = dummy;
      while (prev.next != null && prev.next.next != null) {
        ListNode tmp = prev.next;
        prev.next = prev.next.next;
        tmp.next = prev.next.next;
        prev.next.next = tmp;
        prev = prev.next.next;
      }
      return dummy.next;
    }
  }
}
