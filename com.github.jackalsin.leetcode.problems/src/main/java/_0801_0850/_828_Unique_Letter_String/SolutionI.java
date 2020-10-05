package _0801_0850._828_Unique_Letter_String;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 9/2/2020
 */
public final class SolutionI implements Solution {
  private static final char A = 'A';
  private static final int MOD = (int) (1E9 + 7);

  public int uniqueLetterString(String s) {
    final int n = s.length();
    final int[] prev = new int[n], next = new int[n];
    final int[] visited = new int[26];
    Arrays.fill(visited, -1);
    final char[] chars = s.toCharArray();
    for (int i = 0; i < n; ++i) {
      final char chr = chars[i];
      prev[i] = visited[chr - A];
      visited[chr - A] = i;
    }
    Arrays.fill(visited, n);
    for (int i = n - 1; i >= 0; --i) {
      final char chr = chars[i];
      next[i] = visited[chr - A];
      visited[chr - A] = i;
    }
//    System.out.println(Arrays.toString(prev));
//    System.out.println(Arrays.toString(next));
    int sum = 0;
    for (int i = 0; i < n; ++i) {
      sum = safeAdd(sum, (i - prev[i]) * (next[i] - i));
    }
    return sum;
  }

  private static int safeAdd(final long a, final long b) {
    return (int) ((a + b) % MOD);
  }
}
