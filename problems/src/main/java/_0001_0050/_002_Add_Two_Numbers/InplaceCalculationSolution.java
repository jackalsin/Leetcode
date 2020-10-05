package _0001_0050._002_Add_Two_Numbers;

import definition.ListNode;

/**
 * This solution is aimed to inplace calculation to avoid create an additional {@code ListNode}.
 *
 * @author jacka
 * @version 1.0 on 2017/1/6.
 */
public final class InplaceCalculationSolution implements Solution {
  /**
   * You are given two non-empty linked lists representing two non-negative integers. The digits are
   * stored in reverse order and each of their nodes contain a single digit. Add the two numbers and
   * return it as a linked list.
   * <p>
   * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
   * <p>
   * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
   *
   * @param l1 argument 1, non-empty
   * @param l2 argument 2, non-empty
   * @return sum of the two arguments.
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null || l2 == null) {
      throw new NullPointerException();
    }

    int carry = 0;
    ListNode dummy = new ListNode(Integer.MIN_VALUE);
    dummy.next = l1;
    ListNode cur = dummy.next;
    while (carry != 0 || cur != null || l2 != null) {
      int l1Val = cur == null ? 0 : cur.val;
      int l2Val = l2 == null ? 0 : l2.val;
      int val = l1Val + l2Val + carry;
      cur.val = val % 10;
      carry = val / 10;
      if ((carry != 0 || (l2 != null && l2.next != null)) && cur.next == null) {
        cur.next = new ListNode(0);
      }
      cur = cur.next;
      if (l2 != null) {
        l2 = l2.next;
      }
    }
    return dummy.next;
  }
}
