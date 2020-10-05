package microsoft._021_Merge_Two_Sorted_Lists;

import definition.ListNode;

public class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    final ListNode dummy = new ListNode(1);
    ListNode cur = dummy;
    while (l1 != null || l2 != null) {
      if (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
          cur.next = new ListNode(l1.val);
          l1 = l1.next;
        } else {
          cur.next = new ListNode(l2.val);
          l2 = l2.next;
        }
      } else if (l1 == null) {
        cur.next = new ListNode(l2.val);
        l2 = l2.next;
      } else {
        cur.next = new ListNode(l1.val);
        l1 = l1.next;
      }
      cur = cur.next;
    }
    return dummy.next;
  }
}
