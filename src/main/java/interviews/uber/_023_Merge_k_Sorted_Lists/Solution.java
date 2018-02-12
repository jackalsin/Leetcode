package interviews.uber._023_Merge_k_Sorted_Lists;

import java.util.Comparator;
import java.util.PriorityQueue;

import utils.ListNode;

/**
 * Time complexity: O(n * log(k))
 * for an array of size k, total n ListNode
 *
 * @author jacka
 * @version 1.0 on 2/12/2018.
 */
public class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    final ListNode dummyHead = new ListNode(1);
    ListNode cur = dummyHead;
    final PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
        return Integer.compare(o1.val, o2.val);
      }
    });
    for (final ListNode list : lists) {
      if (list != null) {
        pq.add(list);
      }
    }
//    pq.addAll(Arrays.asList(lists)); // 这是错误的示范： 可能是null
    while (!pq.isEmpty()) {
      ListNode toRemove = pq.remove();
      if (toRemove.next != null) {
        pq.add(toRemove.next);
      }
      cur.next = toRemove;
      cur = cur.next;
    }
    return dummyHead.next;
  }
}
