package _0001_0050._023_Merge_k_Sorted_Lists;

import utils.ListNode;

import java.util.PriorityQueue;

/**
 * @author jacka
 * @version 1.0 on 1/23/2017.
 */
public class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null) {
      return null;
    } else {
      ListNode dummy = new ListNode(0);
      ListNode cur = dummy;
      PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.val, o2.val));
      for (int i = 0; i < lists.length; i++) {
        if (lists[i] != null) {
          pq.add(lists[i]);
        }
      }
      while (!pq.isEmpty()) {
        ListNode curNode = pq.poll();
        cur.next = curNode;
        cur = cur.next;
        if (cur.next != null) {
          pq.add(curNode.next);
        }
      }
      return dummy.next;
    }
  }
}
