package linkedin._061_Rotate_List;

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
    final int size = getSize(head);
    k %= size;
    final ListNode dummy = new ListNode(1);
    dummy.next = head;
    ListNode fast = dummy, slow = dummy;
    for (int i = 0; i < k; ++i) {
      fast = fast.next;
    }
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }

    fast.next = dummy.next;
    dummy.next = slow.next;
    slow.next = null;
    return dummy.next;
  }

  private static int getSize(final ListNode head) {
    int count = 0;
    ListNode cur = head;
    while (cur != null) {
      cur = cur.next;
      ++count;
    }
    return count;
  }
}
