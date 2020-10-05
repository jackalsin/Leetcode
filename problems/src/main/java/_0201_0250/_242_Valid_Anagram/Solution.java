package _0201_0250._242_Valid_Anagram;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/20/2017.
 */
public class Solution {
  public boolean isAnagram(String s, String t) {
    Map<Character, Integer> map = new HashMap<>();
    for (char child : s.toCharArray()) {
      map.put(child, map.getOrDefault(child, 0) + 1);
    }

    for(char child: t.toCharArray()) {
      int beforeRemove = map.getOrDefault(child, 0);
      if(beforeRemove == 0) {
        return false;
      } else if (beforeRemove == 1) {
        map.remove(child);
      } else {
        map.put(child, beforeRemove - 1);
      }
    }
    return map.size() == 0;
  }
}
