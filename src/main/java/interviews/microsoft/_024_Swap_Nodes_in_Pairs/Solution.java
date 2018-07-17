package interviews.microsoft._024_Swap_Nodes_in_Pairs;

import utils.ListNode;

public class Solution {
  public ListNode swapPairs(ListNode head) {
    final ListNode dummy = new ListNode(1);
    dummy.next = head;
    ListNode cur = dummy;

    while (cur.next != null && cur.next.next != null) {
      final ListNode first = cur.next, second = cur.next.next;
      first.next = second.next;
      cur.next = second;
      second.next = first;

      cur = cur.next.next;
    }
    return dummy.next;
  }
}
