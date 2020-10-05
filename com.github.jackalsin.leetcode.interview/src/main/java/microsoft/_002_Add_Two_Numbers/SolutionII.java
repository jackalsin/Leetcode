package microsoft._002_Add_Two_Numbers;

import utils.ListNode;

public final class SolutionII implements Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    final ListNode dummy = new ListNode(1);
    ListNode curNode = dummy;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {

      int l1Val = 0, l2Val = 0;
      if (l1 != null) {
        l1Val = l1.val;
        l1 = l1.next;
      }

      if (l2 != null) {
        l2Val = l2.val;
        l2 = l2.next;
      }

      final int sum = l1Val + l2Val + carry, digit = sum % 10;
      carry = sum / 10;
      curNode.next = new ListNode(digit);
      curNode = curNode.next;
    }

    return dummy.next;
  }
}
