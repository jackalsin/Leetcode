package linkedin._748_Shortest_Completing_Word;

import java.util.HashMap;
import java.util.Map;

public final class SolutionIII implements Solution {
  public String shortestCompletingWord(String licensePlate, String[] words) {
    final Map<Character, Integer> counts = getCounts(licensePlate);
    String res = null;
    int minLen = Integer.MAX_VALUE;
    for (String word : words) {
      if (isMatch(word, new HashMap<>(counts))) {
        if (minLen > word.length()) {
          res = word;
          minLen = word.length();
        }
      }
    }
    return res;
  }

  private static boolean isMatch(final String word, final Map<Character, Integer> counts) {
    int count = counts.size();
    for (int i = 0; i < word.length(); ++i) {
      final char chr = word.charAt(i);
      if (counts.containsKey(chr)) {
        final int prevCount = counts.get(chr);
        counts.put(chr, prevCount - 1);
        if (prevCount == 1) {
          count--;
        }
      }
    }
    return count == 0;
  }

  private static Map<Character, Integer> getCounts(final String licensePlate) {
    final Map<Character, Integer> counts = new HashMap<>();
    for (char chr : licensePlate.toCharArray()) {
      if (!Character.isLetter(chr)) continue;
      chr = Character.toLowerCase(chr);
      counts.put(chr, counts.getOrDefault(chr, 0) + 1);
    }
    return counts;
  }
}
