package interviews.uber._242_Valid_Anagram;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  /**
   * Time Complexity: O(N)
   *
   * @param s
   * @param t
   * @return
   */
  public boolean isAnagram(String s, String t) {
    if (s == null && t == null) {
      return true;
    } else if (s == null || t == null) {
      return false;
    }
    final Map<Character, Integer> counts = new HashMap<>();
    for (final char chr : s.toCharArray()) {
      counts.put(chr, counts.getOrDefault(chr, 0) + 1);
    }

    for (final char chr : t.toCharArray()) {
      if (counts.containsKey(chr)) {
        final int count = counts.get(chr);
        if (count == 1) {
          counts.remove(chr);
        } else {
          counts.put(chr, count - 1);
        }
      } else {
        return false;
      }
    }
    return counts.size() == 0;
  }
}
