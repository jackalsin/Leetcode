package linkedin._002_Add_Two_Numbers;

import definition.ListNode;

public final class SolutionII implements Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    assert l1 != null && l2 != null;
    final ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
      final int l1Val = l1 == null ? 0 : l1.val,
          l2Val = l2 == null ? 0 : l2.val,
          sum = l1Val + l2Val + carry,
          val = sum % 10;
      carry = sum / 10;
      cur.next = new ListNode(val);

      if (l1 != null) l1 = l1.next;
      if (l2 != null) l2 = l2.next;
      cur = cur.next;
    }
    return dummy.next;
  }

}
