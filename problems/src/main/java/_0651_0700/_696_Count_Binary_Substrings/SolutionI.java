package _0651_0700._696_Count_Binary_Substrings;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 3/15/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int countBinarySubstrings(String s) {
    final Queue<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < s.length(); ++i) {
      final char chr = s.charAt(i);
      int count = 1;
      while (i + 1 < s.length() && s.charAt(i + 1) == chr) {
        count++;
        ++i;
      }
      q.add(count);
    }
    if (q.isEmpty()) {
      return 0;
    }
    int res = 0, prev = q.remove();
    while (!q.isEmpty()) {
      final int cur = q.remove();
      res += Math.min(prev, cur);
      prev = cur;
    }
    return res;
  }
}
