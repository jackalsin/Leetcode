package interviews.uber._023_Merge_k_Sorted_Lists;

import utils.ListNode;

/**
 * Time complexity: O(n * log(k))
 * for an array of size k, total n ListNode
 *
 * @author jacka
 * @version 1.0 on 2/12/2018.
 */
public interface Solution {
  ListNode mergeKLists(ListNode[] lists);
}
