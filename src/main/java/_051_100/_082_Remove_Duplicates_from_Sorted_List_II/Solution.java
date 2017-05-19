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
    while (prev != null) {
      ListNode cur = prev.next;
      boolean hasDup = false;
      if (cur != null) {
        ListNode next = cur.next;
         hasDup = false;
        while (cur != null && next != null && cur.val == next.val) {
          cur = cur.next;
          next = next.next;
          hasDup = true;
        }
        prev.next = hasDup ? next : cur;

      }
      if (!hasDup) {
        prev = prev.next;
      }
    }
    return dummyHead.next;
  }
}
