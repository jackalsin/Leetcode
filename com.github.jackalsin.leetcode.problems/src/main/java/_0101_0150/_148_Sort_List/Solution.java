package _0101_0150._148_Sort_List;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public class Solution {
  public ListNode sortList(ListNode head) {
    return sortList(head, null);
  }

  /**
   * @param head inclusive
   * @param end  exclusive
   * @return
   */
  private ListNode sortList(ListNode head, ListNode end) {
    if (head == end || head.next == end) {
      return head;
    } else {
      ListNode slow = head, fast = head;
      while (fast.next != end && fast.next.next != end) {
        slow = slow.next;
        fast = fast.next.next;
      }
      ListNode rightHead = slow.next;
      slow.next = null;
      ListNode right = sortList(rightHead, end);
      ListNode left = sortList(head, null);
      return merge(left, right);
    }
  }

  private ListNode merge(ListNode left, ListNode right) {
    ListNode dummy = new ListNode(1);
    ListNode cur = dummy;
    while (true) {
      if (left != null && right == null) {
        cur.next = left;
        return dummy.next;
      } else if (left == null && right == null) {
        return dummy.next;
      } else if (left == null) {
        cur.next = right;
        return dummy.next;
      } else {
        if (left.val < right.val) {
          cur.next = left;
          left = left.next;
        } else {
          cur.next = right;
          right = right.next;
        }
        cur = cur.next;
      }
    }
  }
}
