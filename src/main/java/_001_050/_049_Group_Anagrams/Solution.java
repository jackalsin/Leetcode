package _001_050._049_Group_Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
