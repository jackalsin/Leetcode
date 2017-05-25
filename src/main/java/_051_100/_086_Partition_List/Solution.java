package _051_100._086_Partition_List;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 5/23/2017.
 */
public class Solution {

  public ListNode partition(ListNode head, int x) {
    if (head == null) return null;
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode cur = dummy;
    // now cur points to x
    ListNode prev = cur;
    cur = cur.next;
    while (cur != null) {
      if (cur.val < x) {
        // link head
        ListNode headPrev = dummy;
        while (headPrev.next != cur && headPrev.next.val < cur.val) {
          headPrev = headPrev.next;
        }
        if (headPrev.next != cur) { // no one is smaller before itself
          // detach tail
          prev.next = cur.next;
          // link head
          cur.next = headPrev.next;
          headPrev.next = cur;
        } else {
          prev = prev.next;
        }
      } else {
        prev = prev.next;
      }
      cur = prev.next;
    }
    return dummy.next;
  }
}
