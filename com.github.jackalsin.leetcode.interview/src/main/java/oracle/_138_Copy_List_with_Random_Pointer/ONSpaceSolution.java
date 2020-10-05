package oracle._138_Copy_List_with_Random_Pointer;


import utils._138_Copy_List_with_Random_Pointer.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 10/20/2019
 */
public final class ONSpaceSolution implements Solution {
  private final Map<Node, Node> srcToCopy = new HashMap<>();

  public Node copyRandomList(Node head) {
    if (head == null) {
      return null;
    }
    if (srcToCopy.containsKey(head)) {
      return srcToCopy.get(head);
    }
    final Node copy = new Node();
    copy.val = head.val;
    srcToCopy.put(head, copy);
    copy.next = copyRandomList(head.next);
    copy.random = copyRandomList(head.random);
    return copy;
  }
}
