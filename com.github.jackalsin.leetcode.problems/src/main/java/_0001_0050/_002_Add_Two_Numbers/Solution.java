package _0001_0050._002_Add_Two_Numbers;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 2017/1/6.
 */
public interface Solution {
  /**
   * You are given two non-empty linked lists representing two non-negative integers. The digits are
   * stored in reverse order and each of their nodes contain a single digit. Add the two numbers and
   * return it as a linked list.
   * <p>
   * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
   * <p>
   * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
   *
   * @param l1 argument 1
   * @param l2 argument 2
   * @return sum of the two arguments.
   */
  ListNode addTwoNumbers(ListNode l1, ListNode l2);
}
