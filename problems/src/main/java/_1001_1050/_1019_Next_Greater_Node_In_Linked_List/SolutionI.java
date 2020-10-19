package _1001_1050._1019_Next_Greater_Node_In_Linked_List;

import definition.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jacka
 * @version 1.0 on 10/18/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] nextLargerNodes(ListNode head) {
    if (head == null) return new int[0];
    final LinkedList<Integer> result = new LinkedList<>();
    final ListNode reversed = reverse(head);
    final Deque<Integer> stack = new ArrayDeque<>();
    ListNode cur = reversed;
//    System.out.println(reversed);
    while (cur != null) {
      while (!stack.isEmpty() && stack.peek() <= cur.val) {
        stack.pop();
      }
      result.addFirst(stack.isEmpty() ? 0 : stack.peek());
      stack.push(cur.val);
      cur = cur.next;
    }
//    System.out.println(result);
    return result.stream().mapToInt(x -> x).toArray();
  }

  private static ListNode reverse(final ListNode head) {
    final ListNode dummy = new ListNode(1);
    dummy.next = head;
    while (head.next != null) {
      final ListNode next = head.next,
          nextNext = head.next.next;
      head.next = nextNext;
      next.next = dummy.next;
      dummy.next = next;
    }

    return dummy.next;
  }

}
