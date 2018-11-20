package _751_800._767_Reorganize_String;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
  public String reorganizeString(String S) {
    final int[] count = new int[26];
    for (char chr : S.toCharArray()) {
      count[chr - 'a']++;
    }
    final Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(final int[] a, final int[] b) {
        return Integer.compare(b[1], a[1]);
      }
    });

    for (int i = 0; i < count.length; i++) {
      if (count[i] == 0) continue;
      pq.add(new int[]{(i + 'a'), count[i]});
    }

    final StringBuilder sb = new StringBuilder();

    while (!pq.isEmpty()) {
      final int[] first = pq.poll();
      if (sb.length() == 0 || sb.charAt(sb.length() - 1) != first[0]) {
        sb.append((char) first[0]);
        if (--first[1] > 0) {
          pq.add(first);
        }
      } else {
        final int[] second = pq.poll();
        if (second == null) {
          return ""; // not possible
        }
        sb.append((char) second[0]);
        if (--second[1] > 0) {
          pq.add(second);
        }
        pq.add(first);
      }
    }

    return sb.toString();
  }
}
