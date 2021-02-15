package apple._767_Reorganize_String;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 2/12/2021
 */
public final class SolutionI implements Solution {
  private static final char A = 'a';

  public String reorganizeString(String s) {
    final int[] chars = new int[26];
    int max = 0;
    for (final char chr : s.toCharArray()) {
      chars[chr - A]++;
      max = Math.max(chars[chr - A], max);
    }
    // {chr, count}
    final Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
    for (int i = 0; i < 26; ++i) {
      if (chars[i] == 0) continue;
      pq.add(new int[]{i, chars[i]});
    }
    if (max * 2 - 1 > s.length()) {
      return "";
    }
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); ++i) {
      final int[] first = pq.remove();
      final char firstChar = (char) (first[0] + A);
      if (sb.length() == 0 || sb.charAt(i - 1) != firstChar) {
        sb.append(firstChar);
        first[1]--;
      } else {
        final int[] second = pq.remove();
        final char secondChar = (char) (second[0] + A);
        sb.append(secondChar);
        second[1]--;
        if (second[1] > 0) {
          pq.add(second);
        }
      }
      if (first[1] > 0) {
        pq.add(first);
      }
    }
    assert sb.length() == s.length();
    return sb.toString();
  }
}
