package _0801_0850._821_Shortest_Distance_to_a_Character;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 9/1/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] shortestToChar(String s, char C) {
    final int n = s.length();
    final int[] result = new int[n];
    Arrays.fill(result, Integer.MAX_VALUE);
    final Queue<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < s.length(); ++i) {
      final char chr = s.charAt(i);
      if (chr == C) {
        q.add(i);
      }
    }
    int dist = 0;
    while (!q.isEmpty()) {
      final int size = q.size();
      for (int i = 0; i < size; ++i) {
        final int toRemove = q.remove(),
            before = toRemove - 1,
            after = toRemove + 1;
        if (result[toRemove] != Integer.MAX_VALUE) {
          continue;
        }
        result[toRemove] = dist;
        if (isInRange(before, 0, n - 1) && result[before] == Integer.MAX_VALUE) {
          q.add(before);
        }
        if (isInRange(after, 0, n - 1) && result[after] == Integer.MAX_VALUE) {
          q.add(after);
        }
      } // end of for
      dist++;
    }
    return result;
  }

  private static boolean isInRange(final int val, final int start, final int end) {
    return start <= val && val <= end;
  }
}
