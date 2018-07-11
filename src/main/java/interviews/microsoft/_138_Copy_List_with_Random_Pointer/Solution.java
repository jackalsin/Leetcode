package interviews.microsoft._138_Copy_List_with_Random_Pointer;

import utils.RandomListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  private final Map<RandomListNode, RandomListNode> oldToNew = new HashMap<>();

  public RandomListNode copyRandomList(RandomListNode head) {
    RandomListNode curNode = head;

    while (curNode != null) {
      final RandomListNode curNodeCopy = new RandomListNode(curNode.label);
      oldToNew.put(curNode, curNodeCopy);
      curNode = curNode.next;
    }

    curNode = head;
    while (curNode != null) {
      oldToNew.get(curNode).next = oldToNew.get(curNode.next);
      oldToNew.get(curNode).random = oldToNew.get(curNode.random);
      curNode = curNode.next;
    }
    return oldToNew.get(head);
  }
}
