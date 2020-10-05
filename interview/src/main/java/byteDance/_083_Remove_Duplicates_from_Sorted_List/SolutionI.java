package byteDance._083_Remove_Duplicates_from_Sorted_List;

import definition.ListNode;

/**
 * @author zhixi
 * @version 1.0 on 5/7/2020
 */
public final class SolutionI implements Solution {
  @Override
  public ListNode deleteDuplicates(ListNode head) {
    ListNode first = head;
    while (first != null) {
      ListNode cur = first;
      // stop at last
      while (cur.next != null && cur.val == cur.next.val) {
        cur = cur.next;
      }
      first.next = cur.next;
      first = cur.next;
    }
    return head;
  }
}
