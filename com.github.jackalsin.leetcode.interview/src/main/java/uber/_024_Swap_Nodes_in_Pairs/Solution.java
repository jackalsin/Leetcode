package uber._024_Swap_Nodes_in_Pairs;

import definition.ListNode;

/**
 * @author jacka
 * @version 1.0 on 2/12/2018.
 */
public class Solution {
  public ListNode swapPairs(ListNode head) {
    final ListNode dummyHead = new ListNode(1);
    dummyHead.next = head;
    ListNode cur = dummyHead;
    while (cur.next != null && cur.next.next != null) {
      final ListNode curNext = cur.next, curNextNext = cur.next.next;
      cur.next = curNextNext;
      curNext.next = curNextNext.next;
      curNextNext.next = curNext;

      cur = cur.next.next;
    }
    return dummyHead.next;
  }
}
