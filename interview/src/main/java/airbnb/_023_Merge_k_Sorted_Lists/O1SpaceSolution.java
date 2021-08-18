package airbnb._023_Merge_k_Sorted_Lists;

import definition.ListNode;

/**
 * @author jacka
 * @version 1.0 on 1/21/2019.
 */
public final class O1SpaceSolution implements Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) return null;
    int size = lists.length;
    while (size != 1) {
      for (int i = 0, j = 0; i < size; i += 2, ++j) {
        lists[j] = merge2(lists[i], i + 1 == size ? null : lists[i + 1]);
      }
      size = (1 + size) / 2;
    }
    return lists[0];
  }

  private static ListNode merge2(final ListNode list1, final ListNode list2) {
    if (list1 == null) return list2;
    if (list2 == null) return list1;
    final ListNode dummy = new ListNode(0);
    ListNode cur1 = list1, cur2 = list2, cur = dummy;
    while (cur1 != null || cur2 != null) {
      if (cur1 == null || cur2 != null && cur1.val >= cur2.val) {
        cur.next = cur2;
        cur = cur.next;
        cur2 = cur2.next;
      } else {
        cur.next = cur1;
        cur = cur.next;
        cur1 = cur1.next;
      }
    }
    return dummy.next;
  }
}
