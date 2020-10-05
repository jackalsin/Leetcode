package linkedin._021_Merge_Two_Sorted_Lists;

import definition.ListNode;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public final class SolutionII implements Solution {
  /**
   * 208 / 208 test cases passed.
   * Status: Accepted
   * Runtime: 16 ms
   *
   * @param l1
   * @param l2
   * @return
   */
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    final ListNode dummy = new ListNode(-1);
    ListNode cur = dummy;

    while (l1 != null || l2 != null) {
      if (l1 != null && l2 != null) {
        if (l1.val > l2.val) {
          cur.next = l2;
          l2 = l2.next;
        } else {
          cur.next = l1;
          l1 = l1.next;
        }
        cur = cur.next;
      } else if (l1 == null) {
        cur.next = l2;
        l2 = null;
      } else {
        cur.next = l1;
        l1 = null;
      }
    }

    return dummy.next;
  }
}
