package interviews.google._049_Group_Anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 1/21/2018.
 */
public class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    final Map<Map<Character, Integer>, List<String>> result = new HashMap<>();
    for (String str : strs) {
      final Map<Character, Integer> charCounts = new HashMap<>();
      for (char chr : str.toCharArray()) {
        charCounts.put(chr, charCounts.getOrDefault(chr, 0) + 1);
      }
      final List<String> updatedList = result.getOrDefault(charCounts, new ArrayList<>());
      updatedList.add(str);
      result.put(charCounts, updatedList);
    }
    return new ArrayList<>(result.values());
  }
}
