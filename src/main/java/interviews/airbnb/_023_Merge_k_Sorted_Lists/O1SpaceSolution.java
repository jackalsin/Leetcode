package interviews.airbnb._023_Merge_k_Sorted_Lists;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 1/21/2019.
 */
public final class O1SpaceSolution implements Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null) {
      return null;
    }
    int size = lists.length;
    while (size != 1) {
      for (int i = 0, j = 0; i < size; i += 2, j++) {
        ListNode l1 = lists[i], l2 = i + 1 < size ? lists[i + 1] : null;
        final ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
          final int l1Val = l1 == null ? Integer.MAX_VALUE : l1.val,
              l2Val = l2 == null ? Integer.MAX_VALUE : l2.val;
          if (l1Val < l2Val) {
            cur.next = new ListNode(l1Val);
            l1 = l1.next;
          } else {
            cur.next = new ListNode(l2Val);
            l2 = l2.next;
          }
          cur = cur.next;
        } // while loop
        lists[j] = dummy.next;
      }
    }
    return lists[0];
  }
}
