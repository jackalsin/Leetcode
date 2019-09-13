package interviews.linkedin._636_Exclusive_Time_of_Functions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/12/2019
 */
public final class SolutionV implements Solution {
  private static final String START = "start", END = "end", SEP = ":";

  public int[] exclusiveTime(int n, List<String> logs) {
    final int[] res = new int[n];
    final Deque<Integer> stack = new ArrayDeque<>();
    int prevStartTime = 0;
    for (final String log : logs) {
      final String[] items = log.split(SEP);
      final int id = Integer.parseInt(items[0]), time = Integer.parseInt(items[2]);
      if (START.equals(items[1])) {
        if (!stack.isEmpty()) {
          res[stack.peek()] += time - prevStartTime;
        }
        stack.push(id);
        prevStartTime = time;
      } else {
        assert stack.pop() == id;
        res[id] += time - prevStartTime + 1;
        prevStartTime = time + 1;
      }
    }
//    System.out.println(Arrays.toString(res));
    return res;
  }
}
