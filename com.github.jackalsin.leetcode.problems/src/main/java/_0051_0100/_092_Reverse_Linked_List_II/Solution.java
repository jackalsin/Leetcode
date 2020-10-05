package _0051_0100._092_Reverse_Linked_List_II;

import definition.ListNode;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 5/31/2017.
 */
public class Solution {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode prev = dummy;
    ListNode last = dummy;
    for (int i = 0; i < n - m + 1; i++) {
      last = last.next;
    }
    for (int i = 0; i < m - 1; i++) {
      last = last.next;
      prev = prev.next;
    }
    while (prev.next != last) {
      ListNode first = prev.next;
      prev.next = first.next;
      first.next = last.next;
      last.next = first;
    }
    return dummy.next;
  }

}
