package oracle._002_Add_Two_Numbers;

import definition.ListNode;

/**
 * @author jacka
 * @version 1.0 on 10/22/2019
 */
public final class SolutionI implements Solution {
  @Override
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    final ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
      final int val1 = l1 == null ? 0 : l1.val,
          val2 = l2 == null ? 0 : l2.val,
          sum = val1 + val2 + carry,
          curVal = sum % 10;
      carry = sum / 10;
      cur.next = new ListNode(curVal);
      l1 = l1 == null ? null : l1.next;
      l2 = l2 == null ? null : l2.next;
      cur = cur.next;
    }
    return dummy.next;
  }
}
