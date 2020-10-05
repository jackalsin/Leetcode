package linkedin._138_Copy_List_with_Random_Pointer;

import utils._138_Copy_List_with_Random_Pointer.Node;

import java.util.HashMap;
import java.util.Map;

public final class SolutionI implements Solution {
  public Node copyRandomList(Node head) {
    final Map<Node, Node> oldToNew = new HashMap<>();
    return copyRandomList(oldToNew, head);
  }

  private static Node copyRandomList(final Map<Node, Node> oldToNew,
                                     final Node old) {
    if (old == null) {
      return null;
    }
    if (oldToNew.containsKey(old)) {
      return oldToNew.get(old);
    }
    final Node newNode = new Node(old.val, null, null);
    oldToNew.put(old, newNode);
    newNode.next = copyRandomList(oldToNew, old.next);
    newNode.random = copyRandomList(oldToNew, old.random);
    return newNode;
  }
}
