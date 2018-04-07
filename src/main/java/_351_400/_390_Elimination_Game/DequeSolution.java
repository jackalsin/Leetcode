package _351_400._390_Elimination_Game;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeSolution implements Solution {
  /**
   * Time Complexity: O (N)
   *
   * @param n
   * @return
   */
  public int lastRemaining(int n) {
    final Deque<Integer> stack1 = new ArrayDeque<>(), stack2 = new ArrayDeque<>();
    for (int i = n; i > 0; i--) {
      stack2.push(i);
    }
    while (true) {
      if (stack1.isEmpty()) {
        if (stack2.size() == 1) {
          return stack2.pop();
        } else {
          iterate(stack2, stack1);
        }
      } else if (stack2.isEmpty()) {
        if (stack1.size() == 1) {
          return stack1.pop();
        } else {
          iterate(stack1, stack2);
        }
      } else {
        throw new IllegalStateException("Either stack1 or stack2 should be empty.");
      }
    }
  }

  private static void iterate(final Deque<Integer> from, final Deque<Integer> to) {
    boolean skip = true;
    while (!from.isEmpty()) {
      if (skip) {
        skip = false;
        from.pop();
      } else {
        to.push(from.pop());
        skip = true;
      }
    }
  }
}
