package apple._636_Exclusive_Time_of_Functions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/1/2021
 */
public final class SolutionII implements Solution {
  private static final String DELIMITER = ":",
      START = "start", END = "end";

  public int[] exclusiveTime(int n, List<String> logs) {
    final int[] result = new int[n];
    int prevStartTime = 0;
    final Deque<Integer> stack = new ArrayDeque<>();
    for (final String log : logs) {
      final String[] items = log.split(DELIMITER);
      final int curId = Integer.parseInt(items[0]),
          time = Integer.parseInt(items[2]);
      if (START.equals(items[1])) {
        if (!stack.isEmpty()) {
          result[stack.peek()] += time - prevStartTime;
        }
        stack.push(curId);
        prevStartTime = time;
      } else {
        assert END.equals(items[1]);
        assert curId == stack.pop();
        result[curId] += time - prevStartTime + 1;
        prevStartTime = time + 1;
      }
    }
    return result;
  }
}
