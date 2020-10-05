package google.first_non_repeatable_char;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 1/20/2018.
 */
public final class TwoMapSolution implements Solution {

  public char firstNonRepeatableChar(final String s) {
    final Map<Character, Integer> charToIndex = new HashMap<>(), counts = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      final char chr = s.charAt(i);
      counts.put(chr, counts.getOrDefault(chr, 0) + 1);
      charToIndex.putIfAbsent(chr, i);
    }

    counts.entrySet().removeIf(characterIntegerEntry -> characterIntegerEntry.getValue() > 1);
    return counts.entrySet().stream().min((o1, o2) -> Integer.compare(o1.getValue(), o2.getValue
        ())).get().getKey();
  }
}
