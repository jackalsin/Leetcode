package microsoft._445_Add_Two_Numbers_II;

import utils.ListNode;

public final class ReverseSolution implements Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    l1 = reverse(l1);
    l2 = reverse(l2);
    ListNode dummy = new ListNode(0);
    ListNode curNode = dummy;
    int carry = 0;
    while (carry != 0 || l1 != null || l2 != null) {
      final int l1Val = l1 == null ? 0 : l1.val, l2Val = l2 == null ? 0 : l2.val,
          val = l1Val + l2Val + carry;
      if (l1 != null) l1 = l1.next;
      if (l2 != null) l2 = l2.next;
      carry = val / 10;
      curNode.next = new ListNode(val % 10);
      curNode = curNode.next;
    }
    dummy = dummy.next;
    return reverse(dummy);
  }

  private static ListNode reverse(ListNode l1) {
    final ListNode dummy = new ListNode(1);
    dummy.next = l1;
    ListNode tailNode = l1;
    while (tailNode.next != null) {
      tailNode = tailNode.next;
    }
    while (dummy.next != tailNode) {
      final ListNode tmp = dummy.next;
      dummy.next = dummy.next.next;
      tmp.next = tailNode.next;
      tailNode.next = tmp;
    }
    return tailNode;
  }
}
