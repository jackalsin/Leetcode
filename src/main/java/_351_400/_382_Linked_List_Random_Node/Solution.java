package _351_400._382_Linked_List_Random_Node;

import java.util.Random;

import utils.ListNode;

/**
 * @author jacka
 * @version 1.0 on 11/9/2017.
 */
public class Solution {
  private final ListNode head;
  private final int size;
  private final Random random;
  /** @param head The linked list's head.
  Note that the head is guaranteed to be not null, so it contains at least one node. */
  public Solution(ListNode head) {
    this.head = head;
    int size = 0;
    while (head != null) {
      size++;
      head = head.next;
    }
    this.size = size;
    random = new Random();
  }

  /** Returns a random node's value. */
  public int getRandom() {
    int count = random.nextInt(size);
    ListNode cur = head;
    while (count-- != 0) {
      cur = cur.next;
    }
    return cur.val;
  }
}
