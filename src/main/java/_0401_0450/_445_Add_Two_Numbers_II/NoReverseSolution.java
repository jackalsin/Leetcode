package _0401_0450._445_Add_Two_Numbers_II;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 5/9/2020
 */
public final class NoReverseSolution implements Solution {
  @Override
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    final int count1 = getCount(l1), count2 = getCount(l2);
    if (count1 < count2) {
      final ListNode tmp = l1;
      l1 = l2;
      l2 = tmp;
    }
    final ListNode dummy = new ListNode(0);
    ListNode cur = dummy, lastNot9 = dummy;
    for (int i = 0; i < Math.abs(count2 - count1); ++i) {
      cur.next = new ListNode(l1.val);
      if (l1.val != 9) lastNot9 = cur.next;
      cur = cur.next;
      l1 = l1.next;
    }
    while (l1 != null) {
      int val = l1.val + l2.val;
      if (val >= 10) {
        val -= 10;
        lastNot9.val++;
        lastNot9 = lastNot9.next;
        while (lastNot9 != null) { // clear the behind
          lastNot9.val = 0;
          lastNot9 = lastNot9.next;
        }
      }
      cur.next = new ListNode(val);

      if (val != 9) lastNot9 = cur.next;
      l1 = l1.next;
      l2 = l2.next;
      cur = cur.next;
    }
    return dummy.val == 0 ? dummy.next : dummy;
  }

  private static int getCount(ListNode l1) {
    int count = 0;
    while (l1 != null) {
      count++;
      l1 = l1.next;
    }
    return count;
  }
}
