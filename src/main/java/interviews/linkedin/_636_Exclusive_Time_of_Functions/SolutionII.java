package interviews.linkedin._636_Exclusive_Time_of_Functions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public final class SolutionII implements Solution {

  private static final String START = "start", END = "end";

  public int[] exclusiveTime(int n, List<String> logs) {
    final int[] res = new int[n];
    int start = 0;
    final Deque<Integer> stack = new ArrayDeque<>();
    for (final String log : logs) {
      final String[] logEntry = log.split(":");
      final int id = Integer.parseInt(logEntry[0]), time = Integer.parseInt(logEntry[2]);
      if (START.equals(logEntry[1])) {
        if (!stack.isEmpty()) {
          res[stack.peek()] += time - start;
        }
        stack.push(id);
        start = time;
      } else { // end
        res[stack.pop()] += time - start + 1;

        start = time + 1;
      }
    }
    return res;
  }
}
