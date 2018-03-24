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
    final Map<Map<Character, Integer>, List<String>> charCountToString = new HashMap<>();
    for (final String str : strs) {
      final Map<Character, Integer> charCount = getCharCounts(str);
      charCountToString.putIfAbsent(charCount, new ArrayList<>());
      charCountToString.get(charCount).add(str);
    }
    final List<List<String>> result = new ArrayList<>();
    for (final Map.Entry<Map<Character, Integer>, List<String>> entry : charCountToString.entrySet()) {
      result.add(entry.getValue());
    }
    return result;
  }

  private Map<Character, Integer> getCharCounts(String str) {
    final Map<Character, Integer> res = new HashMap<>();
    for (final char chr : str.toCharArray()) {
      res.put(chr, res.getOrDefault(chr, 0) + 1);
    }
    return res;
  }
}
