package facebook._025_Reverse_Nodes_in_k_Group;

import utils.ListNode;

public class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    final ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode cur = dummy;

    res:
    while (cur != null) {
      ListNode tail = cur;
      for (int i = 0; i < k; i++) {
        tail = tail.next;
        if (tail == null) {
          break res;
        }
      }

      // tail found

      while (cur.next != tail) {
        final ListNode next = cur.next;
        cur.next = next.next;
        next.next = tail.next;
        tail.next = next;
      }

      // finished inserting, match cur
      for (int i = 0; i < k; i++) {
        cur = cur.next;
      }
    }
    return dummy.next;
  }
}
