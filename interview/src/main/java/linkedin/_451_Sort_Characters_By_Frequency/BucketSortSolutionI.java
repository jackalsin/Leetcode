package linkedin._451_Sort_Characters_By_Frequency;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/8/2019
 */
public final class BucketSortSolutionI implements Solution {
  @Override
  public String frequencySort(String s) {
    if (s == null) {
      return s;
    }
    final int[] charCount = new int[128];
    for (final char chr : s.toCharArray()) {
      charCount[chr]++;
    }
    final List<Character>[] buckets = new ArrayList[s.length() + 1];
    for (int i = 0; i < charCount.length; ++i) {
      final char chr = (char) i;
      final int count = charCount[i];
      if (buckets[count] == null) {
        buckets[count] = new ArrayList<>();
      }
      buckets[count].add(chr);
    }
    final StringBuilder sb = new StringBuilder();
    for (int count = s.length(); count >= 0; --count) {
      final List<Character> chars = buckets[count];
      if (chars == null) continue;
      for (final char chr : chars) {
        for (int i = 0; i < count; ++i) {
          sb.append(chr);
        }
      }
    }
    return sb.toString();
  }
}
