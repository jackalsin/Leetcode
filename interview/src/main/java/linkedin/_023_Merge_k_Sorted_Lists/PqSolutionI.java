package linkedin._023_Merge_k_Sorted_Lists;

import definition.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public final class PqSolutionI implements Solution {

  @Override
  public ListNode mergeKLists(ListNode[] lists) {
    final ListNode dummy = new ListNode(0);
    final Queue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
    for (final ListNode list : lists) {
      if (list != null) pq.add(list);
    }
    ListNode cur = dummy;
    while (!pq.isEmpty()) {
      final ListNode toRemove = pq.remove();
      cur.next = new ListNode(toRemove.val);
      if (toRemove.next != null) pq.add(toRemove.next);
      cur = cur.next;
    }
    return dummy.next;
  }
}
