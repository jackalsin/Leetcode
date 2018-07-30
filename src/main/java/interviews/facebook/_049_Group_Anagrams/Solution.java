package interviews.facebook._049_Group_Anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    final Map<Map<Character, Integer>, List<String>> charCountMap = new HashMap<>();

    for (String str : strs) {
      final Map<Character, Integer> charCount = getCharCount(str);
      final List<String> cur = charCountMap.getOrDefault(charCount, new ArrayList<>());
      cur.add(str);
      charCountMap.put(charCount, cur);
    }
    return new ArrayList<>(charCountMap.values());
  }

  private static Map<Character, Integer> getCharCount(String str) {
    final Map<Character, Integer> res = new HashMap<>();
    for (final char chr : str.toCharArray()) {
      res.put(chr, res.getOrDefault(chr, 0) + 1);
    }
    return res;
  }
}
