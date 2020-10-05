package google.reservoir_sampling._382_Linked_List_Random_Node;

import definition.ListNode;

import java.util.Random;

/**
 * @author jacka
 * @version 1.0 on 1/10/2018.
 */
public class Solution {
  private ListNode head;
  private static final int K = 1;
  private final Random random = new Random();

  /**
   * @param h The linked list's head.
   *          Note that the head is guaranteed to be not null, so it contains at least one node.
   *          https://www.geeksforgeeks.org/reservoir-sampling/
   */
  public Solution(ListNode h) {
    this.head = h;

  }

  /**
   * Returns a random node's value.
   */
  public int getRandom() {
    ListNode head = this.head;
    int[] reserved = new int[K];
    int i = 0;
    for (; i < K; i++) {
      reserved[i] = head.val;
      head = head.next;
    }
    while (head != null) {
      int n = random.nextInt(i + 1);
      i++;
      int candidate = head.val;
      head = head.next;
      if (n < K) {
        reserved[n] = candidate;
      }
    }
    return reserved[0];
  }
}
