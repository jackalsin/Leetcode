package _1001_1050._1019_Next_Greater_Node_In_Linked_List;

import definition.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/18/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] nextLargerNodes(final ListNode head) {
    if (head == null) return new int[0];
    final List<Integer> result = new ArrayList<>();
    /*{index, val}, decreasing*/
    final Deque<int[]> stack = new ArrayDeque<>();
    ListNode cur = head;
    int i = 0;
    while (cur != null) {
      result.add(0); // insert dummy;
      while (!stack.isEmpty() && stack.peek()[1] < cur.val) {
        final int[] toRemove = stack.pop();
        result.set(toRemove[0], cur.val);
      }
      stack.push(new int[]{i, cur.val});
      i++;
      cur = cur.next;
    }
//    System.out.println(result);
    return getInts(result);
  }

  private static int[] getInts(final List<Integer> input) {
    final int[] result = new int[input.size()];
    for (int i = 0; i < input.size(); ++i) {
      result[i] = input.get(i);
    }
    return result;
  }
}
