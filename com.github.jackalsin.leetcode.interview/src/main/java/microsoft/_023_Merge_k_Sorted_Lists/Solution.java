package microsoft._023_Merge_k_Sorted_Lists;

import utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    final Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
      @Override
      public int compare(ListNode l1, ListNode l2) {
        return Integer.compare(l1.val, l2.val);
      }

    });

    for (ListNode listNode : lists) {
      if (listNode != null) {
        queue.add(listNode);
      }
    }

    final ListNode dummy = new ListNode(1);
    ListNode cur = dummy;
    while (!queue.isEmpty()) {
      final ListNode toRemove = queue.remove();
      cur.next = new ListNode(toRemove.val);
      if (toRemove.next != null) {
        queue.add(toRemove.next);
      }
      cur = cur.next;
    }
    return dummy.next;
  }
}
