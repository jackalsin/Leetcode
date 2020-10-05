package uber._206_Reverse_Linked_List;

import definition.ListNode;

public class Solution {
  /**
   * Time complexity O(N)
   *
   * @param head
   * @return
   */
  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }
    final ListNode dummyHead = new ListNode(233);
    dummyHead.next = head;
    ListNode cur = dummyHead.next.next, tail = dummyHead.next;
    while (cur != null) {
      final ListNode newNext = dummyHead.next;
      tail.next = cur.next;
      dummyHead.next = cur;
      cur.next = newNext;
      cur = tail.next;
    }
    return dummyHead.next;
  }
}
