package _0051_0100._061_Rotate_List;

import utils.ListNode;

public final class OptimalSolution implements Solution {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) {
      return head;
    }
    final ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode slow = dummy, fast = dummy;
    int len = 0;
    while (fast.next != null) {
      fast = fast.next;
      len++;
    }

    for (int j = 0; j < len - k % len; ++j) {
      slow = slow.next;
    }
    fast.next = dummy.next;
    dummy.next = slow.next;
    slow.next = null;
    return dummy.next;
  }

}
