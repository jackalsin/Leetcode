package linkedin._159_Longest_Substring_with_At_Most_Two_Distinct_Characters;

import java.util.HashMap;
import java.util.Map;

public final class SolutionI implements Solution {
  @Override
  public int lengthOfLongestSubstringTwoDistinct(String s) {
    final Map<Character, Integer> charMap = new HashMap<>();
    int maxLen = 0, left = 0;
    for (int right = 0; right < s.length(); ++right) {
      final char chr = s.charAt(right);
      charMap.put(chr, charMap.getOrDefault(chr, 0) + 1);
      while (charMap.size() > 2) {
        final char leftChar = s.charAt(left);
        final int prevCount = charMap.get(leftChar);
        if (prevCount == 1) {
          charMap.remove(leftChar);
        } else {
          charMap.put(leftChar, prevCount - 1);
        }
        left++;
      }
      maxLen = Math.max(right - left + 1, maxLen);
    }
    return maxLen;
  }
}
