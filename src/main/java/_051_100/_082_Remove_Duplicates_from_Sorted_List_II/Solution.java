package _051_100._082_Remove_Duplicates_from_Sorted_List_II;

import utils.ListNode;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 5/19/2017.
 */
public class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
    dummyHead.next = head;
    ListNode prev = dummyHead;
    ListNode cur = prev.next;
    while (cur != null) {
      while (cur.next != null && cur.next.val == cur.val) {
        cur = cur.next;
      }
      if (prev.next == cur) { // no dup, prev move
        prev = prev.next;
      } else { //has dup
        prev.next = cur.next;
      }
      cur = cur.next;
    }
    return dummyHead.next;
  }
}
