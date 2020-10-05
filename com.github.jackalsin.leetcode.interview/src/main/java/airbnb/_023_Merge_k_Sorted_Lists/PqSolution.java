package airbnb._023_Merge_k_Sorted_Lists;

import definition.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 1/21/2019.
 */
public final class PqSolution implements Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    final Queue<ListNode> pq = new PriorityQueue<>(new Comparator<>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
        return Integer.compare(o1.val, o2.val);
      }
    });
    final ListNode dummy = new ListNode(0);
    for (ListNode l : lists) {
      if (l != null) {
        pq.add(l);
      }
    }
    ListNode cur = dummy;
    while (!pq.isEmpty()) {
      final ListNode toRemove = pq.remove();
      cur.next = toRemove;
      if (toRemove.next != null) {
        pq.add(toRemove.next);
      }
      cur = cur.next;
    }
    return dummy.next;
  }
}
