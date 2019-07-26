package interviews.linkedin._636_Exclusive_Time_of_Functions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 7/25/2019
 */
public final class SolutionIV implements Solution {
  private static final String START = "start", END = "end";

  public int[] exclusiveTime(int n, List<String> logs) {
    final int[] result = new int[n];
    final Deque<Integer> stack = new ArrayDeque<>();
    int prevStartTime = 0;
    for (int i = 0; i < logs.size(); i++) {
      final String log = logs.get(i);
      final String[] entries = log.split(":");
      final int id = Integer.parseInt(entries[0]), time = Integer.parseInt(entries[2]);
      if (START.equals(entries[1])) {
        if (!stack.isEmpty()) {
          result[stack.peek()] += (time - prevStartTime);
        }
        stack.push(id);
        prevStartTime = time;
      } else if (END.equals(entries[1])) {
        assert stack.peek() == id;
        stack.pop();
        result[id] += (time - prevStartTime + 1);
        prevStartTime = time + 1;
      }
    }
    return result;
  }
}
