package interviews.uber._636_Exclusive_Time_of_Functions;

import java.util.List;
import java.util.Stack;


public class Solution {
  private static final String START = "start", END = "end";

  /**
   * 这题目是这样的：
   * 如果end signal发出来后，那么之前被抢占的task会开始执行，
   * 例如， 0被1的start 中断了，然后收到了1的end，则0开始执行
   */
  public int[] exclusiveTime(int n, List<String> logs) {
    int preStart = 0;
    final int[] t = new int[n];
    final Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < logs.size(); i++) {
      final String[] logArray = logs.get(i).split(":");
      final int time = Integer.parseInt(logArray[2]), id = Integer.parseInt(logArray[0]);
      if (logArray[1].equals(START)) {
        if (!stack.isEmpty()) {
          t[stack.peek()] += time - preStart;
        }
        stack.push(id);
        preStart = time;
      } else {
        assert stack.peek() == id;
        t[stack.pop()] += time - preStart + 1;
        preStart = time + 1;
      }
    }
    return t;
  }

}
