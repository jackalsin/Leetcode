package interviews.linkedin._636_Exclusive_Time_of_Functions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public final class SolutionI implements Solution {

  private static final String START = "start", END = "end";

  public int[] exclusiveTime(int n, List<String> logs) {
    final int[] res = new int[n];
    final Deque<Integer> stack = new ArrayDeque<>();
    int startTime = 0;
    for (final String log : logs) {
      final String[] items = log.split(":");
      final int id = Integer.parseInt(items[0]), time = Integer.parseInt(items[2]);
      if (START.equals(items[1])) {
        if (!stack.isEmpty()) {
          res[stack.peek()] += (time - startTime);
        }
        startTime = time;
        stack.push(id);
      } else if (END.equals(items[1])) {
        assert stack.pop() == id;
        res[id] += (time - startTime + 1);
        startTime = time + 1;
      }
    }
    return res;
  }
}
