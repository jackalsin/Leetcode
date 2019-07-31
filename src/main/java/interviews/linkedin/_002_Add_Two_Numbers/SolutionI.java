package interviews.linkedin._002_Add_Two_Numbers;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 7/30/2019
 */
public final class SolutionI implements Solution {
  @Override
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    final ListNode head = new ListNode(0);
    ListNode cur = head;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
      final int val1 = l1 == null ? 0 : l1.val,
          val2 = l2 == null ? 0 : l2.val,
          sum = val1 + val2 + carry,
          digit = sum % 10;
      carry = sum / 10;
      cur.next = new ListNode(digit);
      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
      cur = cur.next;
    }
    return head.next;
  }
}
