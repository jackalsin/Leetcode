package _0101_0150._138_Copy_List_with_Random_Pointer;

import utils._138_Copy_List_with_Random_Pointer.Node;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public final class O1SpaceSolution implements Solution {

  /**
   * https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43491/A-solution-with-constant-space
   * -complexity-O(1)-and-linear-time-complexity-O(N)
   *
   * @param head
   * @return
   */
  @Override
  public Node copyRandomList(final Node head) {
    if (head == null) {
      return null;
    }

    // 1. append a copy after
    Node cur = head;
    while (cur != null) {
      final Node next = cur.next,
          toInsert = new Node();
      toInsert.val = cur.val;

      toInsert.next = next;
      cur.next = toInsert;
      cur = next;
    }
    // 2. link the random pointer of the copy node
    cur = head;
    while (cur != null) {
      if (cur.random != null) { // copy next
        cur.next.random = cur.random.next;
      }
      cur = cur.next.next;
    }
    // 3. extract the copy part
    cur = head;
    final Node dummyHead = new Node();
    dummyHead.next = cur.next;
    while (cur != null) {
      final Node next = cur.next, nextCurNode = cur.next.next;
      if (next.next != null) {
        next.next = next.next.next;
      }
      cur.next = nextCurNode;
      cur = nextCurNode;
    }
    return dummyHead.next;
  }
}
