package _601_650._636_Exclusive_Time_of_Functions;

import java.util.List;
import java.util.Stack;

/**
 * @author jacka
 * @version 1.0 on 2/4/2018.
 */
public class Solution {
  private static final String START = "start", END = "end";

  /**
   * Time complexity O(N), Space complexity O(N)
   */
  public int[] exclusiveTime(int n, List<String> logs) {
    final Stack<Integer> stack = new Stack<>();
    final int[] result = new int[n];
    int prev = 0;
    for (final String log : logs) {
      final String[] logArray = log.split(":");
      final int function_id = Integer.parseInt(logArray[0]);
      final int timestamp = Integer.parseInt(logArray[2]);
      switch (logArray[1]) {
        case START:
          /* 始终是前闭后开*/
          if (!stack.isEmpty()) {
            result[stack.peek()] += timestamp - prev;
          }
          prev = timestamp;
          stack.push(function_id);
          break;
        case END:
          result[stack.pop()] += timestamp - prev + 1;
          prev = timestamp + 1;
          break;
      }
    }
    return result;
  }
}
