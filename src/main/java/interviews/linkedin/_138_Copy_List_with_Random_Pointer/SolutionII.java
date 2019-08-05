package interviews.linkedin._138_Copy_List_with_Random_Pointer;

import utils._138_Copy_List_with_Random_Pointer.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/4/2019
 */
public final class SolutionII implements Solution {
  private final Map<Node, Node> map = new HashMap<>();

  public Node copyRandomList(Node head) {
    if (head == null) {
      return null;
    }
    if (map.containsKey(head)) {
      return map.get(head);
    }
    final Node copy = new Node(head.val, null, null);
    map.put(head, copy);
    copy.next = copyRandomList(head.next);
    copy.random = copyRandomList(head.random);
    return copy;
  }
}
