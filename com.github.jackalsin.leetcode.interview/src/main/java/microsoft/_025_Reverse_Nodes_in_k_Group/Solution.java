package microsoft._025_Reverse_Nodes_in_k_Group;

import utils.ListNode;

public class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    final ListNode dummy = new ListNode(1);
    dummy.next = head;
    ListNode curNode = dummy;

    result:
    while (curNode != null) {
      ListNode tailNode = curNode;
      // find tail node
      for (int i = 0; i < k; i++) {
        tailNode = tailNode.next;
        if (tailNode == null) {
          break result;
        }
      }

      while (curNode.next != tailNode) {
        final ListNode firstNode = curNode.next;
        curNode.next = firstNode.next;
        firstNode.next = tailNode.next;
        tailNode.next = firstNode;
      }
      for (int i = 0; i < k; i++) {
        if (curNode == null) break;
        curNode = curNode.next;
      }
    }
    return dummy.next;
  }

}
