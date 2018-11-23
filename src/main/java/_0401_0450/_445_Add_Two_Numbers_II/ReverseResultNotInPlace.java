package _0401_0450._445_Add_Two_Numbers_II;

import utils.ListNode;

/**
 * 1563 / 1563 test cases passed. Status: Accepted Runtime: 47 ms
 *
 * @author jacka
 * @version 1.0 on 10/29/2017.
 */
public class ReverseResultNotInPlace implements Solution {
  @Override
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    final ListNode dummy = new ListNode(-1);
    ListNode r1 = reverse(l1), r2 = reverse(l2);
    int carry = 0;
    while (r1 != null || r2 != null || carry == 1) {
      if (r1 != null && r2 != null) {
        carry = addToHead(dummy, r1.val + r2.val + carry);
      } else if (r1 != null) {
        carry = addToHead(dummy, r1.val + carry);
      } else if (r2 != null) {
        carry = addToHead(dummy, r2.val + carry);
      } else { // r1 == null && r2 == null
        carry = addToHead(dummy, carry);
      }
      if (r1 != null) {
        r1 = r1.next;
      }
      if (r2 != null) {
        r2 = r2.next;
      }
    }
    return dummy.next;
  }

  private static int addToHead(ListNode dummy, int sum) {
    int carry = sum / 10;
    ListNode curNode = new ListNode(sum % 10);
    curNode.next = dummy.next;
    dummy.next = curNode;
    return carry;
  }
}
