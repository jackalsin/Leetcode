package interviews.byteDance._025_Reverse_Nodes_in_k_Group;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 5/5/2020
 */
public final class SolutionI implements Solution {
  @Override
  public ListNode reverseKGroup(ListNode head, int k) {
    final ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode prevTail = dummy, nextTail = prevTail.next, curTail = null;
    outTrueLoop:
    while (true) {
      curTail = prevTail;
      for (int i = 0; i < k; ++i) {
        if (curTail.next == null) break outTrueLoop;
        curTail = curTail.next;
      }
      while (prevTail.next != curTail) {
        final ListNode toRemove = prevTail.next;
        prevTail.next = toRemove.next;
        toRemove.next = curTail.next;
        curTail.next = toRemove;
      }
      prevTail = nextTail;
      nextTail = prevTail.next;
    }
    return dummy.next;
  }
}
