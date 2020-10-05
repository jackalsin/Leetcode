package _0401_0450._445_Add_Two_Numbers_II;

import definition.ListNode;

/**
 * This solution use all inplace calculation and reverse the parameter.
 * <p>
 * Performance: 1563 / 1563 test cases passed. Status: Accepted Runtime: 49 ms
 *
 * @author jacka
 * @version 1.0 on 10/29/2017.
 */
public class ReverseSolution implements Solution {

  @Override
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode r1 = reverse(l1);
    ListNode r2 = reverse(l2);
    ListNode dummy = new ListNode(1), prev = dummy;
    dummy.next = r1;
    int carry = 0;
    while (r1 != null || r2 != null) {
      if (r1 != null && r2 != null) {
        int val = r1.val + r2.val + carry;
        carry = val / 10;
        r1.val = val % 10;
      } else if (r2 == null) {
        int val = r1.val + carry;
        carry = val / 10;
        r1.val = val % 10;
        prev = prev.next;
        break;
      } else { // r1 == null
        int val = r2.val + carry;
        carry = val / 10;
        r2.val = val % 10;
        prev.next = r2;
        prev = prev.next;
        break;
      }
      prev = prev.next;
      r1 = r1.next;
      r2 = r2.next;
    }
    while (prev.next != null) {
      int newVal = prev.next.val + carry;
      prev.next.val = newVal % 10;
      carry = newVal / 10;
      prev = prev.next;
    }
    if (carry != 0) {
      prev.next = new ListNode(carry);
    }
    return reverse(dummy.next);
  }


}
