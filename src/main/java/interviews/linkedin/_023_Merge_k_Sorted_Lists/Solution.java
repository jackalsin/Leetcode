package interviews.linkedin._023_Merge_k_Sorted_Lists;

import java.util.PriorityQueue;
import java.util.Queue;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    ListNode dummy = new ListNode(-1), cur = dummy;
    Queue<ListNode> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.val, o2.val));
    for (ListNode list : lists) {
      if (list != null) {
        queue.add(list);
      }
    }

    while (!queue.isEmpty()) {
      final ListNode curNode = queue.poll();
      cur.next = curNode;
      cur = cur.next;
      if (curNode.next != null) {
        queue.add(curNode.next);
      }
    }
    return dummy.next;
  }
}
