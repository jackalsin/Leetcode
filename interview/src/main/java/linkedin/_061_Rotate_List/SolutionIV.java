package linkedin._061_Rotate_List;

import definition.ListNode;

/**
 * @author jacka
 * @version 1.0 on 8/22/2019
 */
public final class SolutionIV implements Solution {
  @Override
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) return head;
    final int n = getSize(head), actualK = k % n;
    if (actualK == 0) return head;
    final ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode slow = dummy, fast = dummy;
    for (int i = 0; i < actualK; ++i) {
      fast = fast.next;
    }
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    final ListNode newHead = slow.next;
    slow.next = null;
    fast.next = head;
    return newHead;
  }

  private static int getSize(final ListNode head) {
    int size = 0;
    ListNode cur = head;
    while (cur != null) {
      cur = cur.next;
      size++;
    }
    return size;
  }
}
