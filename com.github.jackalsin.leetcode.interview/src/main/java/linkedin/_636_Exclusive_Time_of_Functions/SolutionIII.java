package linkedin._636_Exclusive_Time_of_Functions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public final class SolutionIII implements Solution {

  private static final String START = "start", END = "end";

  public int[] exclusiveTime(int n, List<String> logs) {
    final int[] res = new int[n];
    final Deque<Integer> stack = new ArrayDeque<>();
    int start = 0;
    for (final String log : logs) { // ["0:start:0",
      final String[] logEntry = log.split(":");
      final int id = Integer.parseInt(logEntry[0]), time = Integer.parseInt(logEntry[2]);
      if (logEntry[1].equals(START)) {
        if (!stack.isEmpty()) {
          res[stack.peek()] += (time - start);
        }
        stack.push(id);
        start = time;
      } else {
        assert stack.pop() == id;
        res[id] += (time - start + 1);
        start = time + 1;
      }
    }
    return res;
  }
}
