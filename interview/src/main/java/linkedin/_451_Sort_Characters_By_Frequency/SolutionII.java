package linkedin._451_Sort_Characters_By_Frequency;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/14/2019
 */
public final class SolutionII implements Solution {
  @Override
  public String frequencySort(String s) {
    final Map<Character, Integer> charCount = getCharCount(s);
    final List<Map.Entry<Character, Integer>> chars = new ArrayList<>(charCount.entrySet());
    chars.sort(new Comparator<Map.Entry<Character, Integer>>() {
      @Override
      public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
        return Integer.compare(e1.getValue(), e2.getValue());
      }
    });
    final StringBuilder sb = new StringBuilder();
    for (int i = chars.size() - 1; i >= 0; --i) {
      final Map.Entry<Character, Integer> e = chars.get(i);
      final char chr = e.getKey();
      final int count = e.getValue();
      for (int k = 0; k < count; ++k) {
        sb.append(chr);
      }
    }
    return sb.toString();
  }

  private static Map<Character, Integer> getCharCount(final String s) {
    final Map<Character, Integer> result = new HashMap<>();
    for (char chr : s.toCharArray()) {
      result.put(chr, result.getOrDefault(chr, 0) + 1);
    }
    return result;
  }
}
