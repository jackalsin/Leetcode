package linkedin._023_Merge_k_Sorted_Lists;

import definition.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public final class SolutionIII implements Solution {
  @Override
  public ListNode mergeKLists(ListNode[] lists) {
    final Queue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
        return Integer.compare(o1.val, o2.val);
      }
    });
    final ListNode dummy = new ListNode(1);
    ListNode cur = dummy;
    for (ListNode l : lists) {
      if (l != null) {
        pq.add(l);
      }
    }

    while (!pq.isEmpty()) {
      final ListNode toRemove = pq.remove();
      cur.next = toRemove; // should I rebuild
      cur = cur.next;
      if (toRemove.next != null) {
        pq.add(toRemove.next);
      }
    }
    return dummy.next;
  }
}
