package interviews.uber._636_Exclusive_Time_of_Functions;

import java.util.List;
import java.util.Stack;


public class Solution {
  private static final String START = "start", END = "end";

  /**
   * 这题目是这样的：
   * 如果end signal发出来后，那么之前被抢占的task会开始执行，
   * 例如， 0被1的start 中断了，然后收到了1的end，则0开始执行
   *
   * @param n
   * @param logs
   * @return
   */
  public int[] exclusiveTime(int n, List<String> logs) {
    final int[] result = new int[n];
    final Stack<Integer> stack = new Stack<>();
    int prevStartTime = 0;
    for (final String log : logs) {
      final String[] logItems = log.split(":");
      final int id = Integer.parseInt(logItems[0]), time = Integer.parseInt(logItems[2]);
      if (logItems[1].equals(START)) {
        if (!stack.isEmpty()) {
          result[stack.peek()] += time - prevStartTime;
        }
        stack.push(id);
        prevStartTime = time;
      } else {
        result[stack.pop()] += time - prevStartTime + 1;
        prevStartTime = time + 1;
      }
    }
    return result;
  }

}
