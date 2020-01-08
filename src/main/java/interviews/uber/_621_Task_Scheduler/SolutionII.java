package interviews.uber._621_Task_Scheduler;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 1/7/2020
 */
public final class SolutionII implements Solution {
  private static final int N = 26;
  private static final char BASE = 'A';

  public int leastInterval(char[] tasks, int n) {
    final int[] count = new int[N];
    int max = 0,
        maxCount = 0; // how many max you have, for example, [a,a,a, b,b,b] ,max count should be 2
    for (char chr : tasks) {
      count[chr - BASE]++;
      if (count[chr - BASE] > max) {
        max = count[chr - BASE];
        maxCount = 1;
      } else if (max == count[chr - BASE]) {
        maxCount++;
      }
    }
    Arrays.sort(count);
    //                            tail + padding
    return Math.max(tasks.length, maxCount + (max - 1) * (n + 1));
  }
}
