package _451_500._451_Sort_Characters_By_Frequency;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class SolutionI implements Solution {

  @Override
  public String frequencySort(String s) {
    final Map<Character, Integer> charCount = new HashMap<>();
    for (char chr : s.toCharArray()) {
      charCount.put(chr, charCount.getOrDefault(chr, 0) + 1);
    }

    final List<Map.Entry<Character, Integer>> sorted = new ArrayList<>(charCount.entrySet());
    sorted.sort(new Comparator<Map.Entry<Character, Integer>>() {

      @Override
      public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
        return Integer.compare(o2.getValue(), o1.getValue());
      }
    });

    final StringBuilder sb = new StringBuilder();
    for (Map.Entry<Character, Integer> entry : sorted) {
      final char chr = entry.getKey();
      final int count = entry.getValue();
      for (int i = 0; i < count; i++) {
        sb.append(chr);
      }
    }

    return sb.toString();
  }

}
