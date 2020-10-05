package _0201_0250._203_Remove_Linked_List_Elements;

import definition.ListNode;

/**
 * @author jacka
 * @version 1.0 on 8/5/2017.
 */
public class Solution {

  public ListNode removeElements(ListNode head, int val) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode prev = dummy;
    while (prev.next != null) {
      if (prev.next.val == val) {
        prev.next = prev.next.next;
      } else {
        prev = prev.next;
      }
    }

    return dummy.next;
  }
}
