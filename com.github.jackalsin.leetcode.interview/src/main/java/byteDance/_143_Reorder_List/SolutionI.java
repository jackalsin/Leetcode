package byteDance._143_Reorder_List;

import utils.ListNode;

/**
 * @author zhixi
 * @version 1.0 on 5/7/2020
 */
public final class SolutionI implements Solution {
  @Override
  public void reorderList(final ListNode head) {
    if (head == null) {
      return;
    }

    ListNode fast = head, slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    final ListNode nextHalf = slow.next;
    slow.next = null;
    final ListNode second = reverse(nextHalf);
    merge(head, second);
  }

  private static void merge(final ListNode l1, final ListNode l2) {
    ListNode itr1 = l1, itr2 = l2;
    while (itr2 != null) {
      final ListNode nextItr1 = itr1.next,
          nextItr2 = itr2.next;
      itr1.next = itr2;
      itr2.next = nextItr1;
      itr1 = nextItr1;
      itr2 = nextItr2;
    }
  }

  private static ListNode reverse(final ListNode head) {
    if (head == null) return head;
    final ListNode dummy = new ListNode(0);
    dummy.next = head;
    while (head.next != null) {
      final ListNode toRemove = head.next;
      head.next = head.next.next;
      toRemove.next = null;

      // append after dummy;
      final ListNode next = dummy.next;
      dummy.next = toRemove;
      toRemove.next = next;
    }
    return dummy.next;
  }
}
