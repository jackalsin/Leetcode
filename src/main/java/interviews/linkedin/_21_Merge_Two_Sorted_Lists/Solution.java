package interviews.linkedin._21_Merge_Two_Sorted_Lists;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1), cur = dummy;
    while (l1 != null || l2 != null) {
      if (l1 == null) {
        cur.next = l2;
        l2 = l2.next;
      } else if (l2 == null) {
        cur.next = l1;
        l1 = l1.next;
      } else {
        if (l1.val < l2.val) {
          cur.next = l1;
          l1 = l1.next;
        } else {
          cur.next = l2;
          l2 = l2.next;
        }
      }
      cur = cur.next;
    }
    return dummy.next;
  }
}
