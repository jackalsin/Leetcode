package oracle._049_Group_Anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 10/24/2019
 */
public final class SolutionI implements Solution {
  @Override
  public List<List<String>> groupAnagrams(String[] strs) {
    final Map<Map<Character, Integer>, List<String>> result = new HashMap<>();
    for (final String str : strs) {
      final Map<Character, Integer> charMap = getCharMap(str);
      result.computeIfAbsent(charMap, x -> new ArrayList<>()).add(str);
    }
    return new ArrayList<>(result.values());
  }

  private static Map<Character, Integer> getCharMap(final String str) {
    final Map<Character, Integer> result = new HashMap<>();
    for (final char chr : str.toCharArray()) {
      result.put(chr, result.getOrDefault(chr, 0) + 1);
    }
    return result;
  }
}
