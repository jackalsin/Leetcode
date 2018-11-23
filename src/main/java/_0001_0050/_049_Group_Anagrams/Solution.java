package _0001_0050._049_Group_Anagrams;

import java.util.*;

/**
 * @author jacka
 * @version 1.0 on 3/2/2017.
 */
public class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0) {
      return new ArrayList<>();
    }
    Map<String, List<String>> charCountMapToWordList = new HashMap<>();
    for (String word : strs) {
      // count
      char[] chars = word.toCharArray();
      Arrays.sort(chars);
      String str = String.valueOf(chars);
      if (!charCountMapToWordList.containsKey(str)) {
        charCountMapToWordList.put(str, new ArrayList<>());
      }
      charCountMapToWordList.get(str).add(word);
    }
    return new ArrayList<>(charCountMapToWordList.values());
  }

}
