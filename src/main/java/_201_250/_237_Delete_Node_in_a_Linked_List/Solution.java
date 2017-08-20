package _201_250._237_Delete_Node_in_a_Linked_List;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 8/19/2017.
 */
public class Solution {
  public void deleteNode(ListNode node) {
    ListNode prev = null;
    while (node.next != null) {
      node.val = node.next.val;
      if (node.next.next == null) {
        prev = node;
      }
      node = node.next;
    }
    assert prev != null;
    prev.next = null;
  }
}
