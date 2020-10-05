package _0301_0350._328_Odd_Even_Linked_List;

import definition.ListNode;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/29/2017.
 */
public class Solution {
  public ListNode oddEvenList(ListNode head) {
    ListNode oddHead = new ListNode(-1), evenHead = new ListNode(-1),
        odd = oddHead, even = evenHead;
    while (head != null && head.next != null) {
      odd.next = head;
      head = head.next;
      odd = odd.next;
      odd.next = null;
      even.next = head;
      head = head.next;
      even = even.next;
      even.next = null;
    }
    if (head != null) {
      odd.next = head;
      head = head.next;
      odd = odd.next;
      odd.next = null;
    }
    odd.next = evenHead.next;
    return oddHead.next;
  }
}
