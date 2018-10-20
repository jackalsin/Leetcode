package interviews.linkedin._382_Linked_List_Random_Node;

import utils.ListNode;

import java.util.Random;

public final class SolutionI implements Solution {
  private final ListNode head;
  private final Random random = new Random();

  public SolutionI(ListNode head) {
    this.head = head;
  }


  public int getRandom() {
    int count = 1;
    ListNode cur = head;
    cur = cur.next;
    ListNode res = head;
    for (; cur != null; cur = cur.next) {
      count++;
      final int die = random.nextInt(count);
      if (die == 0) {
//        continue;
        res = cur;
      }
    }

    return res.val;
  }
}
