package _101_150._138_Copy_List_with_Random_Pointer;

import java.util.HashMap;
import java.util.Map;

import utils.RandomListNode;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public class Solution {
  private Map<RandomListNode, RandomListNode> originToClone = new HashMap<>();

  public RandomListNode copyRandomList(RandomListNode head) {
    if (head == null) {
      return null;
    } else {
      if (originToClone.get(head) == null) {
        RandomListNode dup = new RandomListNode(head.label);
        originToClone.put(head, dup);
        dup.next = copyRandomList(head.next);
        dup.random = copyRandomList(head.random);
        return dup;
      } else {
        return originToClone.get(head);
      }
    }
  }
}
