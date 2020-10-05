package oracle._147_Insertion_Sort_List;

import definition.ListNode;

/**
 * @author jacka
 * @version 1.0 on 11/29/2019
 */
public final class SolutionI implements Solution {
  @Override
  public ListNode insertionSortList(ListNode head) {
    if (head == null) {
      return head;
    }
    final ListNode dummy = new ListNode(Integer.MIN_VALUE);
    dummy.next = head;
    ListNode prev = head;
    while (prev.next != null) {
      final ListNode cur = prev.next;
      if (prev.val <= cur.val) {
        prev = prev.next;
        continue;
      }
      prev.next = prev.next.next;
      ListNode itr = dummy;
      while (itr.next != null && itr.next.val < cur.val) {
        itr = itr.next;
      }
      append(itr, cur);
    }
    return dummy.next;
  }

  private static void append(final ListNode prev, final ListNode cur) {
    final ListNode next = prev.next;
    prev.next = cur;
    cur.next = next;
  }
}
