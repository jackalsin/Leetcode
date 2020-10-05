package linkedin._382_Linked_List_Random_Node;

import utils.ListNode;

import java.util.Random;

/**
 * @author jacka
 * @version 1.0 on 8/14/2019
 */
public final class ReservoirSamplingSolution implements Solution {
  private final ListNode head;
  private final Random rand = new Random();

  public ReservoirSamplingSolution(ListNode head) {
    this.head = head;
  }

  public int getRandom() {
    if (head == null) {
      return 0;
    }
    ListNode cur = head.next;
    int res = head.val, count = 2;
    for (; cur != null; cur = cur.next, ++count) {
      final int pick = rand.nextInt(count);
      if (pick == count - 1) {
        res = cur.val;
      }
    }
    return res;
  }
}
