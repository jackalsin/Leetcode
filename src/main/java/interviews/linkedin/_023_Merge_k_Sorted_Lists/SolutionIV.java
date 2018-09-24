package interviews.linkedin._023_Merge_k_Sorted_Lists;

import utils.ListNode;

public final class SolutionIV implements Solution {
  @Override
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    int n = lists.length, k = n;
    while (k > 1) {
      int j = 0;
      for (int i = 0; i < k; i += 2, ++j) {
        lists[j] = merge2(lists[i], i + 1 >= k ? null : lists[i + 1]);
      }
      k = (k + 1) / 2;
    }
    return lists[0];
  }

  private static ListNode merge2(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    } else if (l2 == null) {
      return l1;
    }
    final ListNode dummy = new ListNode(1);
    ListNode cur = dummy;
    while (l1 != null || l2 != null) {
      if (l1 == null || (l2 != null && l1.val >= l2.val)) {
        cur.next = l2;
        l2 = l2.next;
      } else {
        cur.next = l1;
        l1 = l1.next;
      }
      cur = cur.next;
    }

    return dummy.next;
  }
}
