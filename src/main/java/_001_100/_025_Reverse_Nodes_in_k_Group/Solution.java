package _001_100._025_Reverse_Nodes_in_k_Group;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 2017/1/24.
 */
public class Solution {
  /**
   * Given a linked list, reverse the nodes of a linked list k at a time and return its modified
   * list. k is a positive integer and is less than or equal to the length of the linked list.
   * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as
   * it is.
   * @param head
   * @param k
   * @return
   */
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null) {
      return null;
    } else if (k <= 0){
      throw new IllegalArgumentException("k cannot be lower than 0 but now is " + k);
    } else {
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode prev = dummy;
      while (prev != null) {
        // find the second
        ListNode second = prev;
        for (int i = 0; i < k; i++) {
          if (second.next != null) {
            second = second.next;
          } else {
            return dummy.next;
          }
        }
        // swap                       // very bad code
        while (prev.next != null && prev.next != second) {
          ListNode first = prev.next;
          prev.next = first.next;
          first.next = second.next;
          second.next = first;
        }

        // move to second
        for (int i = 0; i < k; i++) {
          if (prev != null) {
            prev = prev.next;
          }
        }
      }
      return dummy.next;
    }
  }
}
