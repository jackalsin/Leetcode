package _0751_0800._791_Custom_Sort_String;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Time Complexity: O(len(S) + len(T) * log(len(T)))
 * Space Complexity: O(T + S)
 *
 * @author jacka
 * @version 1.0 on 8/30/2020
 */
public final class PQSolution implements Solution {
  @Override
  public String customSortString(String S, String T) {
    final int[] cmps = new int[26];
    Arrays.fill(cmps, 26);
    for (int i = 0; i < S.length(); ++i) {
      final char chr = S.charAt(i);
      cmps[chr - 'a'] = i;
    }
    final Queue<Character> pq = new PriorityQueue<>((c1, c2) -> Integer.compare(cmps[c1 - 'a'], cmps[c2 - 'a']));
    for (char chr : T.toCharArray()) {
      pq.add(chr);
    }
    final StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
      sb.append(pq.remove());
    }
    return sb.toString();
  }
}
