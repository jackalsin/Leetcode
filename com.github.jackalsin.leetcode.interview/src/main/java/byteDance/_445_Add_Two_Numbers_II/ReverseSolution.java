package byteDance._445_Add_Two_Numbers_II;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 5/9/2020
 */
public final class ReverseSolution implements Solution {
  @Override
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    final ListNode r1 = reverse(l1), r2 = reverse(l2);
    final ListNode r3 = add(r1, r2);
    return reverse(r3);
  }

  private static ListNode add(ListNode r1, ListNode r2) {
    final ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    for (int carry = 0; r1 != null || r2 != null || carry != 0; ) {
      final int v1 = r1 == null ? 0 : r1.val,
          v2 = r2 == null ? 0 : r2.val,
          sum = v1 + v2 + carry,
          d = sum % 10;
      carry = sum / 10;
      cur.next = new ListNode(d);
      cur = cur.next;
      if (r1 != null) r1  = r1.next;
      if (r2 != null) r2  = r2.next;
    }
    return dummy.next;
  }

  private static ListNode reverse(ListNode head) {
    final ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode cur = dummy.next;
    while (cur.next != null) {
      final ListNode toInsert = cur.next, next = dummy.next;
      cur.next = toInsert.next;
      dummy.next = toInsert;
      toInsert.next = next;
    }
    return dummy.next;
  }
}
