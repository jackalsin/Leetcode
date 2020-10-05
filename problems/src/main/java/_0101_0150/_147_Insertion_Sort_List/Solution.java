package _0101_0150._147_Insertion_Sort_List;

import definition.ListNode;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public class Solution {
  public ListNode insertionSortList(ListNode head) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode insert = dummy.next;
    ListNode tail = dummy;
    while (insert != null) {
      ListNode preNode = dummy;
      while (preNode.next != insert && insert.val > preNode.next.val) {
        preNode = preNode.next;
      }
      tail.next = insert.next;
      insert.next = preNode.next;
      preNode.next = insert;
      if (tail.next == insert) {
        tail = tail.next;
      }
      insert = tail.next;
    }
    return dummy.next;
  }
}
