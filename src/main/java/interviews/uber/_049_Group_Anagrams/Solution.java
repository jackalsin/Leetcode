package interviews.uber._049_Group_Anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/15/2018.
 */
public class Solution { // TODO:
  public List<List<String>> groupAnagrams(String[] strs) {
    final Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
    final List<List<String>> result = new ArrayList<>();
    for (String str : strs) {
      Map<Character, Integer> charCounts = getCharCounts(str);
      map.putIfAbsent(charCounts, new ArrayList<>());
      map.get(charCounts).add(str);
    }
    for (Map.Entry<Map<Character, Integer>, List<String>> entry : map.entrySet()) {
      result.add(entry.getValue());
    }
    return result;
  }

  private Map<Character, Integer> getCharCounts(String str) {
    final Map<Character, Integer> charCounts = new HashMap<>();
    for (final char chr : str.toCharArray()) {
      charCounts.put(chr, charCounts.getOrDefault(chr, 0) + 1);
    }
    return charCounts;
  }
}
