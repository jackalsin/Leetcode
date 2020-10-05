package _0101_0150._138_Copy_List_with_Random_Pointer;

import utils._138_Copy_List_with_Random_Pointer.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public final class ONSpaceSolution implements Solution {
  private Map<Node, Node> originToClone = new HashMap<>();

  public Node copyRandomList(Node head) {
    if (head == null) {
      return null;
    } else {
      if (originToClone.get(head) == null) {
        Node dup = new Node(head.val, null, null);
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
