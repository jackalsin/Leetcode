package linkedin._451_Sort_Characters_By_Frequency;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 9/8/2019
 */
public final class SolutionIII implements Solution {
  @Override
  public String frequencySort(String s) {
    if (s == null) {
      return null;
    }
    final char[] chars = s.toCharArray();
    final Map<Character, Integer> charCount = new HashMap<>();
    for (char chr : chars) {
      charCount.put(chr, charCount.getOrDefault(chr, 0) + 1);
    }
    final List<Map.Entry<Character, Integer>> result = new ArrayList<>(charCount.entrySet());
    result.sort(new Comparator<Map.Entry<Character, Integer>>() {
      @Override
      public int compare(final Map.Entry<Character, Integer> e1, final Map.Entry<Character, Integer> e2) {
        return -Integer.compare(e1.getValue(), e2.getValue());
      }
    });
    final StringBuilder sb = new StringBuilder();
    for (final Map.Entry<Character, Integer> e : result) {
      final char chr = e.getKey();
      for (int i = 0; i < e.getValue(); ++i) {
        sb.append(chr);
      }
    }
    return sb.toString();
  }
}
