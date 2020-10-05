package linkedin._023_Merge_k_Sorted_Lists;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 8/1/2019
 */
public final class ConstantSpaceSolution implements Solution {
  @Override
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    int size = lists.length;
    while (size > 1) {
      for (int i = 0, j = 0; i < size; i += 2, j++) {
        ListNode left = lists[i], right = i + 1 < size ? lists[i + 1] : null;
        lists[j] = merge2List(left, right);
      }
      size = (size + 1) / 2;
    }
    return lists[0];
  }

  private static ListNode merge2List(ListNode left, ListNode right) {
    if (left == null) {
      return right;
    }
    if (right == null) {
      return left;
    }
    final ListNode dummy = new ListNode(1);
    ListNode cur = dummy;
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
