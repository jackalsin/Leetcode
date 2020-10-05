package uber._138_Copy_List_with_Random_Pointer;

import definition._138_Copy_List_with_Random_Pointer.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 * int label;
 * RandomListNode next, random;
 * RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
  private final Map<Node, Node> oldToNew = new HashMap<>();

  public Node copyRandomList(Node head) {
    if (head == null) {
      return null;
    }
    if (oldToNew.containsKey(head)) {
      return oldToNew.get(head);
    }
    final Node newHead = new Node(head.val, null, null);
    oldToNew.put(head, newHead);
    newHead.next = copyRandomList(head.next);
    newHead.random = copyRandomList(head.random);
    return newHead;
  }
}
