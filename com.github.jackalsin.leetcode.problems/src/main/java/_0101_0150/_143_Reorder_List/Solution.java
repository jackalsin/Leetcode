package _0101_0150._143_Reorder_List;

import definition.ListNode;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/8/2017.
 */
public class Solution {

  public void reorderList(ListNode head) {
    if (head == null || head.next == null) return;
    ListNode middle = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      middle = middle.next;
      fast = fast.next.next;
    } // middle points 3 in {1, 2, 3, 4, 5} or 2 in {1, 2, 3, 4}

    // reverse the remaining
    middle.next = reverse(middle.next, fast);

    ListNode first = head;
    while (first != middle) {
      ListNode firstNext = first.next;
      ListNode second = middle.next;
      ListNode secondNext = second.next;
      first.next = second;
      second.next = firstNext;
      middle.next = secondNext;

      // step forward
      first = firstNext;
    }


  }

  private ListNode reverse(ListNode head, ListNode tail) {
    ListNode dummy = new ListNode(1);
    dummy.next = head;
    while (tail.next != null) tail = tail.next;
    while (dummy.next != tail) {
      ListNode toTail = dummy.next;
      dummy.next = toTail.next;
      toTail.next = tail.next;
      tail.next = toTail;
    }
    return dummy.next;
  }
}
