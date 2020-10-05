package linkedin._002_Add_Two_Numbers;

import definition.ListNode;

public final class SolutionII implements Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    final ListNode dummy = new ListNode(0);
    ListNode cur = dummy;

    int carry = 0;
    while (carry != 0 || l1 != null || l2 != null) {
      final int num1 = l1 == null ? 0 : l1.val, num2 = l2 == null ? 0 : l2.val, sum = num1 + num2 + carry, curDigit =
          sum % 10;
      carry = sum / 10;

      cur.next = new ListNode(curDigit);

      cur = cur.next;

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
