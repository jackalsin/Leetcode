package interviews.linkedin._061_Rotate_List;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 8/22/2019
 */
public final class SolutionIV implements Solution {
  @Override
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) {
      return head;
    }
    final int len = getLen(head);
    k %= len;
    if (k == 0) {
      return head;
    }
    // march k
    ListNode fast = head;
    for (int i = 0; i < k; ++i) {
      fast = fast.next;
    }
    ListNode slow = head;
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    final ListNode newHead = slow.next;
    slow.next = null;
    fast.next = head;
    return newHead;
  }

  private static int getLen(ListNode head) {
    int i = 0;
    while (head != null) {
      i++;
      head = head.next;
    }
    return i;
  }
}
