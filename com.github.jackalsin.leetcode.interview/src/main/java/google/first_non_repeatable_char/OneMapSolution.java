package google.first_non_repeatable_char;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 1/20/2018.
 */
public final class OneMapSolution implements Solution {
  @Override
  public char firstNonRepeatableChar(String s) {
    final Map<Character, Integer> charCounts = new HashMap<>();
    for (char chr : s.toCharArray()) {
      charCounts.put(chr, charCounts.getOrDefault(chr, 0) + 1);
    }

    for (char chr : s.toCharArray()) {
      if (charCounts.get(chr) == 1) {
        return chr;
      }
    }
    throw new IllegalStateException("No such good stuff");
  }
}
