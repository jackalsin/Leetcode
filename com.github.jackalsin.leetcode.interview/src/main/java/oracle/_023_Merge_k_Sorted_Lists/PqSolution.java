package oracle._023_Merge_k_Sorted_Lists;

import utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 10/21/2019
 */
public final class PqSolution implements Solution {
  @Override
  public ListNode mergeKLists(ListNode[] lists) {
    final Queue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
        return Integer.compare(o1.val, o2.val);
      }
    });
    for (final ListNode l : lists) {
      if (l != null) {
        pq.add(l);
      }
    }
    final ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (!pq.isEmpty()) {
      final ListNode toRemove = pq.remove();
      if (toRemove != null) {
        cur.next = toRemove;
        if (toRemove.next != null) {
          pq.add(toRemove.next);
        }
        cur = cur.next;
      }
    }
    return dummy.next;
  }
}
