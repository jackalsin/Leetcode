package linkedin._255_Verify_Preorder_Sequence_in_Binary_Search_Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public final class SolutionI implements Solution {

  public boolean verifyPreorder(int[] preorder) {
    final Deque<Integer> stack = new ArrayDeque<>();
    int lower = Integer.MIN_VALUE;
    for (int num : preorder) {
      if (num < lower) {
        return false;
      }

      while (!stack.isEmpty() && stack.peek() < num) {
        lower = stack.pop();
      }
      stack.push(num);
    }

    return true;
  }


}
