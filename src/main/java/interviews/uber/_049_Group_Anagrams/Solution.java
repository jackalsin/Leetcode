package interviews.uber._049_Group_Anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/15/2018.
 */
public class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    final Map<Map<Character, Integer>, List<String>> charCountsToStrs = new HashMap<>();
    for (final String str : strs) {
      final Map<Character, Integer> charCounts = getCharCounts(str);
      charCountsToStrs.computeIfAbsent(charCounts, x -> new ArrayList<>()).add(str);
    }
    return new ArrayList<>(charCountsToStrs.values());
  }

  private static Map<Character, Integer> getCharCounts(String str) {
    final Map<Character, Integer> charCounts = new HashMap<>();
    for (char chr : str.toCharArray()) {
      charCounts.put(chr, charCounts.getOrDefault(chr, 0) + 1);
    }
    return charCounts;
  }
}
