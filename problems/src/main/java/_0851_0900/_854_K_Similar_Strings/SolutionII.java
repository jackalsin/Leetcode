package _0851_0900._854_K_Similar_Strings;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 9/10/2020
 */
public final class SolutionII implements Solution {
  @Override
  public int kSimilarity(String A, String B) {
    if (A.equals(B)) {
      return 0;
    }
    final Queue<String> q = new ArrayDeque<>() {{
      add(A);
    }};
    final Set<String> visited = new HashSet<>() {{
      add(A);
    }};
    final char[] bChars = B.toCharArray();
    int swap = 0;
    while (!q.isEmpty()) {
      final int size = q.size();
      swap++;
      for (int i = 0; i < size; ++i) {
        final String toRemove = q.remove();
        final Set<String> neighbors = getNeighbors(toRemove, bChars);
        for (final String n : neighbors) {
          if (B.equals(n)) {
            return swap;
          }
          if (visited.add(n)) {
            q.add(n);
          }
        } // end for String n
      }
    }
    throw new IllegalArgumentException(String.format("%s and %s are not anagram", A, B));
  }

  private static Set<String> getNeighbors(final String src, final char[] bChars) {
    final int n = src.length();
    final char[] chars = src.toCharArray();
    final Set<String> result = new HashSet<>();
    for (int i = 0; i < n; ++i) {
      if (chars[i] == bChars[i]) continue;
      for (int j = i + 1; j < n; ++j) {
        if (chars[i] != bChars[j]) continue;
        swap(chars, i, j);
        result.add(String.valueOf(chars));
        swap(chars, i, j);
      }
      return result;
    }
    throw new IllegalArgumentException(String.format("%s and %s are not anagram", src, Arrays.toString(bChars)));
  }

  private static void swap(final char[] chars, final int i, final int j) {
    final char tmp = chars[i];
    chars[i] = chars[j];
    chars[j] = tmp;
  }
}
