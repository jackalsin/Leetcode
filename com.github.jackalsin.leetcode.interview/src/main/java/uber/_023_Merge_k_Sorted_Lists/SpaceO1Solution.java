package uber._023_Merge_k_Sorted_Lists;

import definition.ListNode;

/**
 * Time complexity: O(n * log(k))
 * for an array of size k, total n ListNode
 *
 * @author jacka
 * @version 1.0 on 2/12/2018.
 */
public final class SpaceO1Solution implements Solution {
  public ListNode mergeKLists(ListNode[] lists) {

    int size = lists.length;
    if (size == 0) {
      return null;
    }
    while (size > 1) {
      int j = 0;
      for (int i = 0; i < size; i += 2, j++) {
        final ListNode left = lists[i], right = i + 1 < size ? lists[i + 1] : null;
        lists[j] = merge(left, right);
      }
      size = j;
    }
    return lists[0];
  }

  private static ListNode merge(ListNode left, ListNode right) {
    final ListNode dummy = new ListNode(1);
    ListNode cur = dummy;
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
        // right == null
        cur.next = left;
        left = left.next;
      }
      cur = cur.next;
    }
    return dummy.next;
  }
}
