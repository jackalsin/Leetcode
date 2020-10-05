package facebook._023_Merge_k_Sorted_Lists;

import utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    final PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
        return Integer.compare(o1.val, o2.val);
      }
    });

    final ListNode dummy = new ListNode(1);
    ListNode cur = dummy;
    for (ListNode list : lists) {
      if (list != null) {
        pq.add(list);
      }
    }
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
