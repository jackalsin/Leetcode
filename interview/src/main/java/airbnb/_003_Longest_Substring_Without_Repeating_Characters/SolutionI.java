package airbnb._003_Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;
import java.util.Map;

public final class SolutionI implements Solution {
  public int lengthOfLongestSubstring(String s) {
    final Map<Character, Integer> lastSeen = new HashMap<>();
    int max = 0;
    for (int start = 0, i = 0; i < s.length(); i++) {
      final char chr = s.charAt(i);
      if (lastSeen.containsKey(chr)) {
        start = Math.max(start, lastSeen.get(chr));
      }
      max = Math.max(max, i - start + 1);
      lastSeen.put(chr, i + 1);
    }
    return max;
  }

}
