package uber._023_Merge_k_Sorted_Lists;

import definition.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Time complexity: O(n * log(k))
 * for an array of size k, total n ListNode
 *
 * @author jacka
 * @version 1.0 on 2/12/2018.
 */
public final class PqSolution implements Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    final ListNode dummy = new ListNode(1);
    final Queue<ListNode> pq = new PriorityQueue<>(new Comparator<>() {

      @Override
      public int compare(ListNode o1, ListNode o2) {
        return Integer.compare(o1.val, o2.val);
      }
    });

    for (ListNode list : lists) {
      if (list != null) {
        pq.add(list);
      }
    }
    ListNode cur = dummy;
    while (!pq.isEmpty()) {
      final ListNode toRemove = pq.remove();
      cur.next = toRemove;
      cur = cur.next;
      if (toRemove.next != null) {
        pq.add(toRemove.next);
      }
    }
    return dummy.next;
  }
}
