package oracle._159_Longest_Substring_with_At_Most_Two_Distinct_Characters;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 12/7/2019
 */
public final class SolutionI implements Solution {
  private static final int maxCount = 2;

  @Override
  public int lengthOfLongestSubstringTwoDistinct(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    final char[] chars = s.toCharArray();
    int max = 0, left = 0;
    final Map<Character, Integer> charCount = new HashMap<>();
    for (int right = 0; right < chars.length; right++) {
      final char rightChar = chars[right];
      charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);
      while (charCount.size() > 2) {
        final char leftChar = chars[left];
        if (charCount.containsKey(leftChar)) {
          final int prevCount = charCount.get(leftChar);
          if (prevCount == 1) {
            charCount.remove(leftChar);
          } else {
            charCount.put(leftChar, charCount.get(leftChar) - 1);
          }
        }
        left++;
      }
      max = Math.max(max, right - left + 1);
    }
    return max;
  }
}
