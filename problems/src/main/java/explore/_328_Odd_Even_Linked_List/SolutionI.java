package explore._328_Odd_Even_Linked_List;

import definition.ListNode;

/**
 * @author jacka
 * @version 1.0 on 5/16/2020
 */
public final class SolutionI implements Solution {
  @Override
  public ListNode oddEvenList(final ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    final ListNode evenHead = head.next;
    ListNode odd = head, even = head.next;
    odd.next = null;
    while (even != null && even.next != null) {
      final ListNode nextOdd = even.next,
          nextEven = even.next.next;
      even.next = nextEven;
      odd.next = nextOdd;
      nextOdd.next = null;
      odd = nextOdd;
      even = nextEven;
    }
    odd.next = evenHead;
    return head;
  }
}
