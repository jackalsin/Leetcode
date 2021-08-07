package linkedin._021_Merge_Two_Sorted_Lists;

import definition.ListNode;

/**
 * @author jacka
 * @version 1.0 on 8/2/2019
 */
public final class SolutionIII implements Solution {
  @Override
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    final ListNode dummy = new ListNode(1);
    ListNode cur = dummy;
    while (l1 != null || l2 != null) {
      if (l1 == null) {
        cur.next = new ListNode(l2.val);
        l2 = l2.next;
      } else if (l2 == null) {
        cur.next = new ListNode(l1.val);
        l1 = l1.next;
      } else {
        final int l1Val = l1.val, l2Val = l2.val;
        if (l1Val < l2Val) {
          cur.next = new ListNode(l1Val);
          l1 = l1.next;
        } else {
          cur.next = new ListNode(l2Val);
          l2 = l2.next;
        }
      }
      cur = cur.next;
    }
    return dummy.next;
  }
}
