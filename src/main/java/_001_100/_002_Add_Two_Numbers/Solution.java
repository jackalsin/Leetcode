package _001_100._002_Add_Two_Numbers;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 2017/1/6.
 */
public class Solution {
  /**
   * You are given two non-empty linked lists representing two non-negative integers. The digits are
   * stored in reverse order and each of their nodes contain a single digit. Add the two numbers and
   * return it as a linked list.
   *
   * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
   *
   * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
   *
   * @param l1 argument 1
   * @param l2 argument 2
   * @return sum of the two arguments.
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode ans = new ListNode(-1);
    ListNode cur = ans;
    while (carry != 0 || l1 != null || l2 != null) {
      int l1Val = l1 == null ? 0 : l1.val;
      int l2Val = l2 == null ? 0 : l2.val;
      int val = l1Val + l2Val + carry;
      cur.next = new ListNode(val % 10);
      carry = val / 10;
      cur = cur.next;
      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
    }
    return ans.next;
  }
}
