package interviews.linkedin._061_Rotate_List;

import utils.ListNode;

public final class SolutionIII implements Solution {
  /**
   * @param head
   * @param k
   * @return
   */
  @Override
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || k == 0) {
      return head;
    }
    ListNode cur = head;
    int len = 0;
    while (cur != null) {
      len++;
      cur = cur.next;
    }

    k %= len;
    ListNode fast = head, slow = head;
    for (int i = 0; i < k; i++) {
      fast = fast.next;
    }

    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }

    fast.next = head;
    ListNode newHead = slow.next;
    slow.next = null;
    return newHead;
  }


}
