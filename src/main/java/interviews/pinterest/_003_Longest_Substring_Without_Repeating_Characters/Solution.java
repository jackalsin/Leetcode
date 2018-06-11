package interviews.pinterest._003_Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int lengthOfLongestSubstring(String s) {
    if (s.isEmpty()) {
      return 0;
    }
    int max = 0;
    final Map<Character, Integer> lastSeen = new HashMap<>();
    for (int start = 0, end = 0; end < s.length(); end++) {
      final char chr = s.charAt(end);
      if (lastSeen.containsKey(chr)) {
        start = Math.max(start, lastSeen.get(chr) + 1);
      }
      final int curLen = end - start + 1;
      max = Math.max(curLen, max);
      lastSeen.put(chr, end);
    }
    return max;
  }
}
