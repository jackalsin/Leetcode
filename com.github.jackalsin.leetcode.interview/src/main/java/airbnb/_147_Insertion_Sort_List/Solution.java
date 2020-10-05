package airbnb._147_Insertion_Sort_List;

import definition.ListNode;

/**
 * @author jacka
 * @version 1.0 on 1/26/2019.
 */
public class Solution {
  public ListNode insertionSortList(ListNode head) {
    if (head == null) {
      return head;
    }
    final ListNode dummy = new ListNode(Integer.MIN_VALUE);
    ListNode insert = head;

    while (insert != null) {
      ListNode insertNext = insert.next, prev = dummy;
      while (prev.next != null && prev.next.val < insert.val) {
        prev = prev.next;
      }

      // swap
      insert.next = prev.next;
      prev.next = insert;

      // move
      insert = insertNext;
    }
    return dummy.next;
  }
}
