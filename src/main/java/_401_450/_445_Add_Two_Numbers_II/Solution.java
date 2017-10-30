package _401_450._445_Add_Two_Numbers_II;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 10/29/2017.
 */
public interface Solution {

  ListNode addTwoNumbers(ListNode l1, ListNode l2);

  default ListNode reverse(ListNode l1) {
    if (l1 == null) {
      return null;
    }
    final ListNode dummy = new ListNode(1);
    dummy.next = l1;
    while (l1.next != null) {
      ListNode cur = l1.next;
      l1.next = cur.next;
      cur.next = dummy.next;
      dummy.next = cur;
    }
    return dummy.next;
  }
}
