package _0901_0950._946_Validate_Stack_Sequences;

import java.util.ArrayDeque;
import java.util.Deque;

public final class Solution {

  public boolean validateStackSequences(int[] pushed, int[] popped) {
    final Deque<Integer> stack = new ArrayDeque<>();
    int j = 0;
    for (int p : pushed) {
      stack.push(p);
      while (j < popped.length && !stack.isEmpty() && stack.peek() == popped[j]) {
        stack.pop();
        j++;
      }
    }
    return j == popped.length;
  }
}
