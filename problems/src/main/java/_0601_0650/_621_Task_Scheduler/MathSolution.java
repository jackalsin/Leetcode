package _0601_0650._621_Task_Scheduler;

/**
 * @author jacka
 * @version 1.0 on 3/12/2018.
 */
public final class MathSolution implements Solution {
  /**
   * https://leetcode.com/problems/task-scheduler/discuss/104496/concise-Java-Solution-O(N)-time-O(26)-space
   */
  public int leastInterval(char[] tasks, int n) {
    final int[] counts = new int[26];
    for (final char task : tasks) {
      counts[task - 'A']++;
    }
    int max = 0, maxCount = 0; // how many max
    for (final int count : counts) {
      if (max == count) {
        maxCount++;
      } else if (max < count) {
        max = count;
        maxCount = 1;
      }
    }
    /*首先最大值满足塞满不同的truck*， 然后剩下的再扔maxCount的最大值的字符*/
    return Math.max(tasks.length, (max - 1) * (n + 1) + maxCount);
  }
}

