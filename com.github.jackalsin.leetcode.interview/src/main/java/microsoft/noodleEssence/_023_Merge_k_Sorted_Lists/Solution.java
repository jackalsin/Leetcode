package microsoft.noodleEssence._023_Merge_k_Sorted_Lists;

import utils.ListNode;

public class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    int maxRight = lists.length - 1;
    while (maxRight > 0) {
      int k = 0;
      for (int i = 0; i <= maxRight; i += 2) {
        final ListNode dummy = new ListNode(1);
        ListNode cur = dummy, left = lists[i], right = i + 1 <= maxRight ? lists[i + 1] : null;
        while (left != null || right != null) {
          if (left != null && right != null) {
            if (left.val < right.val) {
              cur.next = left;
              left = left.next;
            } else {
              cur.next = right;
              right = right.next;
            }
          } else if (left == null) {
            cur.next = right;
            right = right.next;
          } else {
            cur.next = left;
            left = left.next;
          }

          cur = cur.next;
        } // end of while loop
        lists[k++] = dummy.next;
      } // end of for loop
      maxRight = k - 1;
    }
    return lists[0];
  }
}
