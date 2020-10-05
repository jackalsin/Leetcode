package linkedin._255_Verify_Preorder_Sequence_in_Binary_Search_Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public final class SolutionIII implements Solution {

  public boolean verifyPreorder(int[] preorder) {
    long preVal = Long.MIN_VALUE;

    final Deque<Integer> stack = new ArrayDeque<>();

    for (int num : preorder) {

      if (num < preVal) {
        return false;
      }

      while (!stack.isEmpty() && stack.peek() < num) {
        preVal = stack.pop();
      }
      stack.push(num);
    }
    return true;
  }

}
