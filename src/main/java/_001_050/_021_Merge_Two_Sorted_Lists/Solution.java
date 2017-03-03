package _001_050._021_Merge_Two_Sorted_Lists;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 1/23/2017.
 */
public class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    } else if (l2 == null) {
      return l1;
    } else {
      ListNode dummy = new ListNode(0);
      ListNode cur = dummy;
      ListNode cur1 = l1;
      ListNode cur2 = l2;
      while (true) {
        if (cur1 != null && cur2 != null) {
          if (cur1.val < cur2.val) {
            cur.next = cur1;
            cur1 = cur1.next;
          } else {
            cur.next = cur2;
            cur2 = cur2.next;
          }
          cur = cur.next;
        } else {
          if (cur1 == null) {
            cur.next = cur2;
          } else {
            cur.next = cur1;
          }
          return dummy.next;
        }
      }
    }

  }
}
