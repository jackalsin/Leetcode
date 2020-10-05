package _0851_0900._876_Middle_of_the_Linked_List;

import definition.ListNode;

/**
 * @author jacka
 * @version 1.0 on 4/8/2020
 */
public final class SolutionI implements Solution {
  @Override
  public ListNode middleNode(final ListNode head) {
    ListNode slow = head, fast = head;
    for (; fast != null && fast.next != null;
         fast = fast.next.next, slow = slow.next) {
    }
    return slow;
  }
}
