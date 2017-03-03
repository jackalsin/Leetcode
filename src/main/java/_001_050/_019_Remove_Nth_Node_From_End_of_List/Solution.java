package _001_050._019_Remove_Nth_Node_From_End_of_List;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 2017/1/22.
 */
public class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy;
    ListNode second = dummy;
    while (n-- > 0) {
      second = second.next;
    }
    while (second.next != null) {
      first = first.next;
      second = second.next;
    }
    first.next = first.next.next;
    return dummy.next;
  }
}
