package interviews.airbnb._049_Group_Anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 1/22/2019.
 */
public class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    final Map<Map<Character, Integer>, List<String>> charCounts = new HashMap<>();

    for (String str : strs) {
      final Map<Character, Integer> charCount = getCharCounts(str);
      charCounts.computeIfAbsent(charCount, x -> new ArrayList<>()).add(str);
    }

    return new ArrayList<>(charCounts.values());
  }

  private static Map<Character, Integer> getCharCounts(final String str) {
    final Map<Character, Integer> res = new HashMap<>();
    for (char chr : str.toCharArray()) {
      res.put(chr, res.getOrDefault(chr, 0) + 1);
    }
    return res;
  }
}
