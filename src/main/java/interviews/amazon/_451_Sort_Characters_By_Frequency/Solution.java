package interviews.amazon._451_Sort_Characters_By_Frequency;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 10/24/2017.
 */
public class Solution {
  private static final int N = 256;

  public String frequencySort(String s) {
    final int[] counts = new int[N];
    for (char chr : s.toCharArray()) {
      counts[chr]++;
    }
    Queue<CharToCount> queue = new PriorityQueue<>(new Comparator<CharToCount>() {
      @Override
      public int compare(CharToCount o1, CharToCount o2) {
        return Integer.compare(o2.count, o1.count);
      }
    });
    for (int i = 0; i < N; ++i) {
      if (counts[i] != 0) {
        queue.add(new CharToCount((char) i, counts[i]));
      }
    }
    StringBuilder sb = new StringBuilder();
    while (!queue.isEmpty()) {
      CharToCount charToCount = queue.poll();
      for (int i = 0; i < charToCount.count; i++) {
        sb.append(charToCount.chr);
      }
    }
    return sb.toString();
  }

  private static final class CharToCount {
    private final char chr;
    private final int count;

    public CharToCount(char chr, int count) {
      this.chr = chr;
      this.count = count;
    }

    @Override
    public String toString() {
      return "CharToCount{" +
          "chr=" + chr +
          ", count=" + count +
          '}';
    }
  }
}
