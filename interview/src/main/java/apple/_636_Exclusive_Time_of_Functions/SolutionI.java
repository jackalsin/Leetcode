package apple._636_Exclusive_Time_of_Functions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/13/2021
 */
public final class SolutionI implements Solution {
  private static final String START = "start", END = "end",
      SEPARATOR = ":";

  public int[] exclusiveTime(int n, List<String> logs) {
    final int[] result = new int[n];
    int preStartTime = -1;
    final Deque<Integer> stack = new ArrayDeque<>();
    for (final String log : logs) {
      final String[] items = log.split(SEPARATOR);
      assert items.length == 3;
      final int id = Integer.parseInt(items[0]),
          timestamp = Integer.parseInt(items[2]);
      if (START.equals(items[1])) {
        if (!stack.isEmpty()) {
          result[stack.peek()] += timestamp - preStartTime;
        }
        stack.push(id);
        preStartTime = timestamp;
      } else {
        assert (END.equals(items[1]));
        final int curId = stack.pop();
        assert curId == id;
        result[id] += timestamp - preStartTime + 1;
        preStartTime = timestamp + 1;
      }
    }
    return result;
  }
}
