package interviews.linkedin._138_Copy_List_with_Random_Pointer;

import utils._138_Copy_List_with_Random_Pointer.Node;

/**
 * @author jacka
 * @version 1.0 on 8/26/2019
 */
public final class O1Solution implements Solution {
  @Override
  public Node copyRandomList(final Node head) {
    if (head == null) {
      return null;
    }
    Node cur = head;
    while (cur != null) {
      final Node copy = new Node();
      copy.val = cur.val;
      copy.next = cur.next;
      copy.random = cur.random;
      cur.next = copy;
      cur = cur.next.next;
    }

    cur = head;
    while (cur != null) {
      final Node copy = cur.next;
      if (copy.random != null) {
        copy.random = copy.random.next;
      }
      cur = cur.next.next;
    }

    final Node copyHead = new Node();
    Node copyCur = copyHead;
    cur = head;
    while (cur != null) {
      copyCur.next = cur.next;
      cur.next = cur.next.next;

      copyCur = copyCur.next;
      cur = cur.next;
    }
    return copyHead.next;
  }
}
