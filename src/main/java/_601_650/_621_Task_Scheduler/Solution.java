package _601_650._621_Task_Scheduler;

/**
 * @author jacka
 * @version 1.0 on 3/11/2018.
 */
public class Solution {
  private static final char BASE = 'A';
  private static final int N = 26;

  public int leastInterval(char[] tasks, int n) {
    final int[] valid = new int[N], counts = new int[N];
    int count = tasks.length;
    for (int i = 0; i < tasks.length; i++) {
      counts[tasks[i] - BASE]++;
    }
    int resultPlusN = n;
    for (int i = 0; count != 0; i++) {
      int candidatePos = findMaxCountValid(counts, valid, i);
      if (candidatePos != -1) {
        count--;
        counts[candidatePos]--;
        valid[candidatePos] = i + n + 1;
        resultPlusN = Math.max(resultPlusN, i + n);
      }
    }
    return resultPlusN - n + 1;
  }

  private int findMaxCountValid(int[] counts, int[] valid, int index) {
    int candidate = -1, maxCount = 0;
    for (int i = 0; i < counts.length; i++) {
      if (counts[i] > maxCount && valid[i] <= index) {
        candidate = i;
        maxCount = counts[i];
      }
    }
    return candidate;
  }
}
