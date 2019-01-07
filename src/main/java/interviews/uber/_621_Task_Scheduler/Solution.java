package interviews.uber._621_Task_Scheduler;

import java.util.Arrays;

public class Solution {
  public int leastInterval(char[] tasks, int n) {
    final int[] counts = new int[26];
    int max = 0, maxCount = 0;
    for (char chr : tasks) {
      counts[chr - 'A']++;
      if (counts[chr - 'A'] > max) {
        max = counts[chr - 'A'];
        maxCount = 1;
      } else if (counts[chr - 'A'] == max) {
        maxCount++;
      }
    }
    Arrays.sort(counts);
    return Math.max(tasks.length, (counts[25] - 1) * (n + 1) + maxCount);
  }
}
