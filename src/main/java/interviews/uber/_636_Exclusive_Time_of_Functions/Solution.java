package interviews.uber._636_Exclusive_Time_of_Functions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solution {
  private static final String START = "start", END = "end";

  /**
   * 这题目是这样的：
   * 如果end signal发出来后，那么之前被抢占的task会开始执行，
   * 例如， 0被1的start 中断了，然后收到了1的end，则0开始执行
   */
  public int[] exclusiveTime(int n, List<String> logs) {
    final int[] res = new int[n];
    final Deque<Integer> stack = new ArrayDeque<>();
    int preStart = 0;
    for (String log : logs) {
      final String[] entries = log.split(":");
      final int id = Integer.parseInt(entries[0]),
          time = Integer.parseInt(entries[2]);
      if (entries[1].equals(START)) {
        if (!stack.isEmpty()) {
          res[stack.peek()] += (time - preStart);
        }
        preStart = time;
        stack.push(id);
      } else if (entries[1].equals(END)) {
        res[stack.pop()] += time - preStart + 1;
        preStart = time + 1;
      }
    }
    return res;
  }

}
