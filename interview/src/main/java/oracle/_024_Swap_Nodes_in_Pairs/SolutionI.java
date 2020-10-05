package oracle._024_Swap_Nodes_in_Pairs;

import definition.ListNode;

/**
 * @author jacka
 * @version 1.0 on 11/24/2019
 */
public final class SolutionI implements Solution {
  @Override
  public ListNode swapPairs(ListNode head) {
    final ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode cur = dummy;
    while (cur.next != null && cur.next.next != null) {
      final ListNode first = cur.next, second = cur.next.next, next = cur.next.next.next;
      cur.next = second;
      second.next = first;
      first.next = next;
      cur = cur.next.next;
    }
    return dummy.next;
  }
}
