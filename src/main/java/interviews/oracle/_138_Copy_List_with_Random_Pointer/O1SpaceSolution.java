package interviews.oracle._138_Copy_List_with_Random_Pointer;

import utils._138_Copy_List_with_Random_Pointer.Node;

/**
 * @author jacka
 * @version 1.0 on 10/20/2019
 */
public final class O1SpaceSolution implements Solution {
  @Override
  public Node copyRandomList(Node head) {
    if (head == null) {
      return null;
    }
    {
      // first pass
      Node cur = head;
      while (cur != null) {
        final Node newCur = new Node();
        newCur.val = cur.val;
        newCur.next = cur.next;
        newCur.random = cur.random;
        insert(cur, newCur);
        cur = cur.next.next;
      }
    }
    {
      // second pass
      Node cur = head;
      while (cur != null) {
        if (cur.random != null) {// it can be null
          cur.next.random = cur.random.next;
        }
        cur = cur.next.next;
      }
    }

    final Node dummy = new Node();
    {
      Node cur = head, newCur = dummy;
      while (cur != null) {
        final Node next = cur.next;
        cur.next = cur.next.next;
        newCur.next = next;
        cur = cur.next;
        newCur = newCur.next;
      }
    }
    return dummy.next;
  }

  private static void insert(final Node prev, final Node cur) {
    final Node next = prev.next;
    prev.next = cur;
    cur.next = next;
  }

}
