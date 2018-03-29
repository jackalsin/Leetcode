package interviews.uber._138_Copy_List_with_Random_Pointer;

import utils.RandomListNode;

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
  private final Map<RandomListNode, RandomListNode> oldToNew = new HashMap<>();

  public RandomListNode copyRandomList(RandomListNode head) {
    if (head == null) {
      return null;
    }
    if (oldToNew.containsKey(head)) {
      return oldToNew.get(head);
    }
    final RandomListNode newHead = new RandomListNode(head.label);
    oldToNew.put(head, newHead);
    newHead.next = copyRandomList(head.next);
    newHead.random = copyRandomList(head.random);
    return newHead;
  }
}
