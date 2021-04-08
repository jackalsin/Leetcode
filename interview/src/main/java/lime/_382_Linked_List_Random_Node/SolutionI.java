package lime._382_Linked_List_Random_Node;

import definition.ListNode;

import java.util.Random;

/**
 * @author jacka
 * @version 1.0 on 4/7/2021
 */
public final class SolutionI implements Solution {
  private final ListNode head;
  private final Random rand = new Random();

  public SolutionI(final ListNode head) {
    assert head != null;
    this.head = head;
  }

  public int getRandom() {
    ListNode cur = head, res = head;
    int count = 1;
    while (cur != null) {
      final int toss = rand.nextInt(count);
      if (toss == count - 1) {
        res = cur;
      }
      count++;
      cur = cur.next;
    }
    return res.val;
  }
}
