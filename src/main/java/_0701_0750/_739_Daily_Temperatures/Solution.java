package _0701_0750._739_Daily_Temperatures;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
    if (temperatures == null || temperatures.length == 0) {
      return new int[0];
    }
    final int[] res = new int[temperatures.length];

    final Deque<Integer> indexStack = new ArrayDeque<>();
    indexStack.push(0);
    for (int i = 1; i < temperatures.length; i++) {
      while (!indexStack.isEmpty() && temperatures[i] > temperatures[indexStack.peek()]) {
        int popIndex = indexStack.pop();
        res[popIndex] = i - popIndex;
      }
      indexStack.push(i);
    }

    return res;
  }
}
