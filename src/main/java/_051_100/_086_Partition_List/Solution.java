package _051_100._086_Partition_List;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 5/23/2017.
 */
public class Solution {
  public ListNode partition(ListNode head, int x) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode cur = dummy;
    while (cur != null && cur.val != x) {
      cur = cur.next;
    }
    // now cur points to x
    ListNode prev = cur;
    cur = cur.next;
    while (cur != null) {
      if (cur.val < x) {
        // detach tail
        prev.next = cur.next;

        // link head
        ListNode headPrev = dummy;
        while (headPrev.next.val < cur.val) {
          headPrev = headPrev.next;
        }
        cur.next = headPrev.next;
        headPrev.next = cur;
      }
      prev = prev.next;
      cur = cur.next;
    }
    return dummy.next;
  }
}
