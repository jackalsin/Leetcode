package _351_400._369_Plus_One_Linked_List;

import java.util.Deque;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 11/7/2017.
 */
public class Solution {
  public ListNode plusOne(ListNode head) {
//    return reverseSolution(head);
    return noReverseSolution(head);
  }

  private static ListNode noReverseSolution(ListNode head) {
    final ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode curNode = head, lastNotNine = dummy;

    while (curNode != null) {
      if (curNode.val != 9) {
        lastNotNine = curNode;
      }
      curNode = curNode.next;
    }
    lastNotNine.val++;
    curNode = lastNotNine.next;
    while (curNode != null) {
      curNode.val = 0;
      curNode = curNode.next;
    }
    return dummy.val == 1 ? dummy:dummy.next;
  }

  private ListNode reverseSolution(ListNode head) {
    ListNode dummy = new ListNode(-1), prev = dummy;
    dummy.next = reverse(head);
    int carry = 0;
    dummy.next.val++;
    while (carry != 0 || prev.next != null) {
      if (carry != 0 && prev.next == null) {
        prev.next = new ListNode(0);
      }
      int sum = carry + prev.next.val;
      prev.next.val = sum % 10;
      carry = sum / 10;
      prev = prev.next;
    }

    return reverse(dummy.next);
  }
  private static ListNode reverse(final ListNode head) {
    ListNode dummy = new ListNode( -1);
    dummy.next = head;
    ListNode cur = dummy.next;
    while (cur.next != null) {
      ListNode tmp = cur.next;
      cur.next = cur.next.next;
      tmp.next = dummy.next;
      dummy.next = tmp;
    }
    return dummy.next;
  }
}
