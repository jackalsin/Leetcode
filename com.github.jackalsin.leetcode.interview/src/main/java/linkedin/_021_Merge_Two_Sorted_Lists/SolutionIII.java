package linkedin._021_Merge_Two_Sorted_Lists;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 8/2/2019
 */
public final class SolutionIII implements Solution {
  @Override
  public ListNode mergeTwoLists(final ListNode l1, final ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    final ListNode dummy = new ListNode(1);
    ListNode left = l1, right = l2, cur = dummy;
    while (left != null || right != null) {
      if (left == null) {
        cur.next = right;
        right = right.next;
      } else if (right == null) {
        cur.next = left;
        left = left.next;
      } else if (left.val < right.val) {
        cur.next = left;
        left = left.next;
      } else {
        cur.next = right;
        right = right.next;
      }
      cur = cur.next;
    }
    return dummy.next;
  }
}
