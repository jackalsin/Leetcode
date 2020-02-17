package interviews.tableau._023_Merge_k_Sorted_Lists;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 2/17/2020
 */
public final class O1Solution implements Solution {
  @Override
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) return null;
    int size = lists.length;
    while (size != 1) {
      for (int i = 0, start = 0; start < size; i++, start += 2) {
        final ListNode left = lists[start],
            right = start + 1 == size ? null : lists[start + 1];
        lists[i] = merge(left, right);
      }
      size = (1 + size) / 2;
    }
    return lists[0];
  }

  private static ListNode merge(ListNode left, ListNode right) {
    if (left == null && right == null) {
      return null;
    } else if (left == null) {
      return right;
    } else if (right == null) {
      return left;
    } else {
      final ListNode dummy = new ListNode(0);
      ListNode cur = dummy;
      while (left != null || right != null) {
        final int leftVal = left == null ? Integer.MAX_VALUE : left.val,
            rightVal = right == null ? Integer.MAX_VALUE : right.val;
        if (leftVal < rightVal) {
          cur.next = new ListNode(leftVal);
          left = left.next;
        } else {
          cur.next = new ListNode(rightVal);
          right = right.next;
        }
        cur = cur.next;
      }
      return dummy.next;
    }
  }
}
