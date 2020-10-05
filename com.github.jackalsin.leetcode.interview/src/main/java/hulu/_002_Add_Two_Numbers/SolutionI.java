package hulu._002_Add_Two_Numbers;

import definition.ListNode;

/**
 * @author jacka
 * @version 1.0 on 2/8/2020
 */
public final class SolutionI implements Solution {
  @Override
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    final ListNode dummy = new ListNode(0);
    int carry = 0;
    for (ListNode cur = dummy; l1 != null || carry != 0 || l2 != null; cur = cur.next) {
      final int l1Val = l1 == null ? 0 : l1.val,
          l2Val = l2 == null ? 0 : l2.val,
          sum = carry + l1Val + l2Val,
          curVal = sum % 10;
      carry = sum / 10;
      cur.next = new ListNode(curVal);
      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
    }
    return dummy.next;
  }
}
