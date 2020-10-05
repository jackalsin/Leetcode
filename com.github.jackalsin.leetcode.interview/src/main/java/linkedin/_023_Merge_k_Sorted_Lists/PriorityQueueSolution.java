package linkedin._023_Merge_k_Sorted_Lists;

import utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 8/1/2019
 */
public final class PriorityQueueSolution implements Solution {
  @Override
  public ListNode mergeKLists(ListNode[] lists) {
    final Queue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
        return Integer.compare(o1.val, o2.val);
      }
    });
    for (ListNode node : lists) {
      if (node == null) continue;
      pq.add(node);
    }
    final ListNode dummy = new ListNode(7);
    ListNode cur = dummy;
    while (!pq.isEmpty()) {
      final ListNode toRemove = pq.remove();
      if (toRemove.next != null) {
        pq.add(toRemove.next);
      }
      cur.next = toRemove;
      cur = cur.next;
    }
    return dummy.next;
  }
}
