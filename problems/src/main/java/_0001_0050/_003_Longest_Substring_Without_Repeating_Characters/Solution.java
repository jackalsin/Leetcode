package _0001_0050._003_Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;
import java.util.Map;

/**
 * Use a hashmap to track the position of each character.
 * Use a pair of pointers to point the start and the end of the substring.
 * <p>
 * Algorithm:
 * When find a duplicated element in hashMap, move left pointer to right to the element in the
 * hashmap.
 *
 * @author jacka
 * @version 1.0 on 2017/1/7.
 */
public class Solution {

  public int lengthOfLongestSubstring(String s) {
    if (s == null) {
      return 0;
    }
    Map<Character, Integer> lastSeen = new HashMap<>();
    int max = 0, start = 0, end = 0;
    for (; end < s.length(); end++) {
      char chr = s.charAt(end);
      if (lastSeen.containsKey(chr)) {
        int curLen = end - start;
        // start = lastSeen.get(chr) + 1; // dont do it: in "abba", when start points 2 and
        // checking end, the start pointer can roll back to 1.
        start = Math.max(start, lastSeen.get(chr) + 1);
        if (curLen > max) {
          max = curLen;
        }
      }
      lastSeen.put(chr, end);
    }
    max = Math.max(end - start, max);
    return max;
  }

}
