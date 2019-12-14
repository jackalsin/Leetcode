package interviews.hulu._049_Group_Anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 12/13/2019
 */
public final class SolutionI implements Solution {
  @Override
  public List<List<String>> groupAnagrams(String[] strs) {
    final List<List<String>> result = new ArrayList<>();
    if (strs == null || strs.length == 0) {
      return result;
    }
    final Map<Map<Character, Integer>, List<String>> charCountToWords = new HashMap<>();
    for (String word : strs) {
      final Map<Character, Integer> charCount = getCharCount(word);
      charCountToWords.computeIfAbsent(charCount, k -> new ArrayList<>()).add(word);
    }
    return new ArrayList<>(charCountToWords.values());
  }

  private static Map<Character, Integer> getCharCount(final String word) {
    final Map<Character, Integer> charCount = new HashMap<>();
    for (final char chr : word.toCharArray()) {
      charCount.put(chr, charCount.getOrDefault(chr, 0) + 1);
    }
    return charCount;
  }
}
