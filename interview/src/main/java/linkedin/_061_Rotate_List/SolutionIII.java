package linkedin._061_Rotate_List;

import definition.ListNode;

public final class SolutionIII implements Solution {
  /**
   * @param head
   * @param k
   * @return
   */
  @Override
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) {
      return head;
    }
    final int n = getSize(head), actualK = k % n;
    if (actualK == 0) {
      return head;
    }
    final ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = head, slow = head;
    for (int i = 0; i < actualK; i++) {
      fast = fast.next;
    }

    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }

    ListNode newHead = slow.next;
    slow.next = null;
    fast.next = dummy.next;
    return newHead;
  }

  private static int getSize(final ListNode head) {
    int n = 0;
    ListNode cur = head;
    while (cur != null) {
      n++;
      cur = cur.next;
    }
    return n;
  }
}
