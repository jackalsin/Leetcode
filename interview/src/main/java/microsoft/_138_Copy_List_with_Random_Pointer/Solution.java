package microsoft._138_Copy_List_with_Random_Pointer;

import definition._138_Copy_List_with_Random_Pointer.Node;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  private final Map<Node, Node> oldToNew = new HashMap<>();

  public Node copyRandomList(Node head) {
    Node curNode = head;

    while (curNode != null) {
      final Node curNodeCopy = new Node(curNode.val, null, null);
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
