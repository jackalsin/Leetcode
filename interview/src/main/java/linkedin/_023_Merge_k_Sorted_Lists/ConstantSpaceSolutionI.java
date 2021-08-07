package linkedin._023_Merge_k_Sorted_Lists;

import definition.ListNode;

public final class ConstantSpaceSolutionI implements Solution {
  @Override
  public ListNode mergeKLists(ListNode[] lists) {
    int len = lists.length;
    if (len == 0) return null;
    while (len != 1) {
      for (int i = 0, j = 0; i < len; i += 2, ++j) {
        lists[j] = merge(lists[i], i + 1 == len ? null : lists[i + 1]);
      }
      len = (len + 1) / 2;
    }
    return lists[0];
  }

  private static ListNode merge(ListNode left, ListNode right) {
    if (left == null) return right;
    if (right == null) return left;
    final ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (left != null || right != null) {
      if (left == null) {
        cur.next = new ListNode(right.val);
        right = right.next;
      } else if (right == null) {
        cur.next = new ListNode(left.val);
        left = left.next;
      } else {
        final int leftVal = left.val, rightVal = right.val;
        if (leftVal < rightVal) {
          cur.next = new ListNode(leftVal);
          left = left.next;
        } else {
          cur.next = new ListNode(rightVal);
          right = right.next;
        }
      }
      cur = cur.next;
    }
    return dummy.next;
  }
}
