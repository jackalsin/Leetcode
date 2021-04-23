package facebook._621_Task_Scheduler;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 4/21/2021
 */
public final class BruteForceSolution implements Solution {
  private static final char A = 'A';
  private static final int N = 26;
  private final int[] validSince = new int[N], counts = new int[N];

  public int leastInterval(char[] tasks, int n) {
    for (final char t : tasks) {
      counts[t - A]++;
    }
    Arrays.fill(validSince, -1);
    int remain = tasks.length, result = 0;
    for (int i = 0; remain != 0; ++i, result++) {
      final Character toRemove = getMaxValid(i);
      if (toRemove == null) continue;
      remain--;
      final int chrIndex = toRemove - A;
      counts[chrIndex]--;
      validSince[chrIndex] = i + n + 1;
    }
    return result;
  }

  private Character getMaxValid(final int index) {
    int maxCount = 0;
    Character maxCountChar = null;
    for (int i = 0; i < N; ++i) {
      if (counts[i] > maxCount && validSince[i] <= index) {
        maxCount = counts[i];
        maxCountChar = (char) (i + A);
      }
    }
    return maxCountChar;
  }
}