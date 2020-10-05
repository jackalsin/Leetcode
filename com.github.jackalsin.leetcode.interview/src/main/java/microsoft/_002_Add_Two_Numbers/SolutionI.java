package microsoft._002_Add_Two_Numbers;

import utils.ListNode;

public final class SolutionI implements Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    final ListNode dummy = new ListNode(-1);
    ListNode cur = dummy;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
      final int l1Val = l1 == null ? 0 : l1.val, l2Val = l2 == null ? 0 : l2.val;
      int res = l1Val + l2Val + carry;
      carry = res / 10;
      cur.next = new ListNode(res % 10);

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
