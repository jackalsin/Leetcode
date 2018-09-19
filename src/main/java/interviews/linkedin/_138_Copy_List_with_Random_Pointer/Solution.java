package interviews.linkedin._138_Copy_List_with_Random_Pointer;

import utils.RandomListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public RandomListNode copyRandomList(RandomListNode head) {
    final Map<RandomListNode, RandomListNode> oldToNew = new HashMap<>();
    return copyRandomList(oldToNew, head);
  }

  private static RandomListNode copyRandomList(final Map<RandomListNode, RandomListNode> oldToNew, final RandomListNode old) {
    if (old == null) {
      return null;
    }
    if (oldToNew.containsKey(old)) {
      return oldToNew.get(old);
    }
    final RandomListNode newNode = new RandomListNode(old.label);
    oldToNew.put(old, newNode);
    newNode.next = copyRandomList(oldToNew, old.next);
    newNode.random = copyRandomList(oldToNew, old.random);
    return newNode;
  }
}
