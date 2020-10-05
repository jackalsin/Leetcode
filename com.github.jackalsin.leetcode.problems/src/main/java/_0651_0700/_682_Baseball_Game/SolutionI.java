package _0651_0700._682_Baseball_Game;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 3/14/2020
 */
public final class SolutionI implements Solution {
  private static final String D = "D", C = "C", PLUS = "+";

  public int calPoints(String[] ops) {
    if (ops == null || ops.length == 0) {
      return 0;
    }
    final int n = ops.length;
    final int[] scores = new int[n];
    int sum = 0;
    final Deque<Integer> validScore = new ArrayDeque<>();
    for (int i = 0; i < ops.length; i++) {
      final String op = ops[i];
      if (D.equals(op)) {
        final int prev = validScore.pop();
        scores[i] = 2 * prev;
        sum += scores[i];
        validScore.push(prev);
        validScore.push(scores[i]);
      } else if (C.equals(op)) {
        sum -= validScore.pop();
      } else if (PLUS.equals(op)) {
        final int prev1 = validScore.pop(), prev2 = validScore.pop(), val = prev1 + prev2;
        scores[i] = val;
        sum += scores[i];
        validScore.push(prev2);
        validScore.push(prev1);
        validScore.push(val);
      } else {
        scores[i] = Integer.parseInt(op);
        sum += scores[i];
        validScore.push(scores[i]);
      }
//      System.out.println(op + ", " + sum);
    }
    return sum;
  }
}
