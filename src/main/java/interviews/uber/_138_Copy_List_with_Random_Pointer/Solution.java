package interviews.uber._138_Copy_List_with_Random_Pointer;

import java.util.HashMap;
import java.util.Map;

import utils.RandomListNode;

public class Solution { // TODO;
  private final Map<RandomListNode, RandomListNode> oldToNew = new HashMap<>();

  public RandomListNode copyRandomList(RandomListNode head) {
    if (head == null) {
      return null;
    }
    if (oldToNew.containsKey(head)) {
      return oldToNew.get(head);
    }
    RandomListNode newHead = new RandomListNode(head.label);
    oldToNew.put(head, newHead);

    newHead.next = copyRandomList(head.next);
    newHead.random = copyRandomList(head.random);
    return newHead;
  }
}
