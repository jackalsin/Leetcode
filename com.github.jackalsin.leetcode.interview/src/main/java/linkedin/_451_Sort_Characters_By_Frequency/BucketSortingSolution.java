package linkedin._451_Sort_Characters_By_Frequency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/14/2019
 */
public final class BucketSortingSolution implements Solution {
  @Override
  public String frequencySort(String s) {
    final Map<Character, Integer> charCount = getCharCount(s);
    final List<List<Character>> buckets = new ArrayList<>();
    for (int i = 0; i <= s.length(); ++i) {
      buckets.add(new ArrayList<>());
    }
    for (final Map.Entry<Character, Integer> e : charCount.entrySet()) {
      buckets.get(e.getValue()).add(e.getKey());
    }
    final StringBuilder sb = new StringBuilder();
    for (int count = buckets.size() - 1; count >= 0; --count) {
      for (char chr : buckets.get(count)) {
        for (int i = 0; i < count; ++i) {
          sb.append(chr);
        }
      }
    }
    return sb.toString();
  }

  private static Map<Character, Integer> getCharCount(final String s) {
    final Map<Character, Integer> map = new HashMap<>();
    for (char chr : s.toCharArray()) {
      map.put(chr, map.getOrDefault(chr, 0) + 1);
    }
    return map;
  }
}
