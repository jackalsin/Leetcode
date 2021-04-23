package facebook._621_Task_Scheduler;

/**
 * @author jacka
 * @version 1.0 on 4/21/2021
 */
public final class MathSolution implements Solution {
  @Override
  public int leastInterval(char[] tasks, int n) {
    int maxCount = 0, countOfMaxCount = 0;
    final int[] counts = new int[26];
    for (final char t : tasks) {
      counts[t - 'A']++;
      if (counts[t - 'A'] > maxCount) {
        maxCount = counts[t - 'A'];
        countOfMaxCount = 1;
      } else if (counts[t - 'A'] == maxCount) {
        countOfMaxCount++;
      }
    }
    // 思路：
    // 1. tasks 长度
    // 2. A????A????A????A????这样做frame，然后每次按照freq append
    //    ABCDEFABCDFABDEF, 就是说n=4，仍然可以append5个，这样避免collision
    return Math.max(tasks.length, (n + 1) * (maxCount - 1) + countOfMaxCount);
  }
}
