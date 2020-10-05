package uber._049_Group_Anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/15/2018.
 */
public final class SolutionI implements Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    final Map<Map<Character, Integer>, List<String>> charCountToMap = new HashMap<>();
    for (final String str : strs) {
      final Map<Character, Integer> charCount = getCharCount(str);
      charCountToMap.computeIfAbsent(charCount, k -> new ArrayList<>()).add(str);
    }
    return new ArrayList<>(charCountToMap.values());
  }

  private static Map<Character, Integer> getCharCount(final String str) {
    final Map<Character, Integer> result = new HashMap<>();
    for (final char chr : str.toCharArray()) {
      result.put(chr, result.getOrDefault(chr, 0) + 1);
    }
    return result;
  }
}
