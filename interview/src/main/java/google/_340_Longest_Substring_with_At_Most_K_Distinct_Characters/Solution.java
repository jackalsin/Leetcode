package google._340_Longest_Substring_with_At_Most_K_Distinct_Characters;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 1/12/2018.
 */
public class Solution {
  public int lengthOfLongestSubstringKDistinct(String s, final int k) {
    final Map<Character, Integer> counts = new HashMap<>();
    int res = 0, start = 0, kk = 0;
    for (int i = 0; i < s.length(); i++) {
      final char chr = s.charAt(i);
      counts.put(chr, counts.getOrDefault(chr, 0) + 1);
      while (counts.size() > k) {
        char prev = s.charAt(start++);
        int preCount = counts.get(prev);
        if (preCount == 1) {
          counts.remove(prev);
        } else {
          counts.put(prev, preCount - 1);
        }
      }
      res = Math.max(res, i - start + 1);
    }
    return res;
  }
}
