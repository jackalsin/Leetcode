package airbnb._021_Merge_Two_Sorted_Lists;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 1/21/2019.
 */
public class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    final ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (l1 != null || l2 != null) {
      final int l1Val = l1 == null ? Integer.MAX_VALUE : l1.val, l2Val = l2 == null ? Integer.MAX_VALUE : l2.val;
      if (l1Val < l2Val) {
        cur.next = new ListNode(l1Val);
        l1 = l1.next;
      } else {
        cur.next = new ListNode(l2Val);
        l2 = l2.next;
      }
      cur = cur.next;
    }
    return dummy.next;
  }
}
