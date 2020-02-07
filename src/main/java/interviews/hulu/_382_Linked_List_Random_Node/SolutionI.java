package interviews.hulu._382_Linked_List_Random_Node;

import utils.ListNode;

import java.util.Random;

/**
 * @author jacka
 * @version 1.0 on 2/6/2020
 */
public final class SolutionI implements Solution {
  private final ListNode head;
  private final Random rand = new Random();

  /**
   * @param head The linked list's head.
   *             Note that the head is guaranteed to be not null, so it contains at least one node.
   */
  public SolutionI(ListNode head) {
    this.head = head;
  }

  public int getRandom() {
    int count = 1;
    ListNode cur = head, res = head;
    while (cur != null) {
      final int toss = rand.nextInt(count);
      if (toss == count - 1) {
        res = cur;
      }
      cur = cur.next;
      count++;
    }
    return res.val;
  }
}
