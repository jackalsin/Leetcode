package _0451_0500._451_Sort_Characters_By_Frequency;

import java.util.ArrayList;
import java.util.List;

public final class SolutionII implements Solution {

  @Override
  public String frequencySort(String s) {
    final int[] counts = new int[256];
    final char[] chars = s.toCharArray();

    for (char chr : chars) {
      counts[chr]++;
    }
    final List<Character>[] buckets = new List[s.length() + 1];
    for (int i = 0; i < counts.length; i++) {
      final char chr = (char) i;
      final int count = counts[i];
      if (buckets[count] == null) {
        buckets[count] = new ArrayList<>();
      }
      buckets[count].add(chr);
    }
    final StringBuilder sb = new StringBuilder();
    for (int count = buckets.length - 1; count >= 0; count--) {
      if (buckets[count] == null) {
        continue;
      }
      for (char chr : buckets[count]) {
        for (int i = 0; i < count; i++) {
          sb.append(chr);
        }
      }
    }
    return sb.toString();
  }
}
