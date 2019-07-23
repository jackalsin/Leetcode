package interviews.linkedin._340_Longest_Substring_with_At_Most_K_Distinct_Characters;

import java.util.HashMap;
import java.util.Map;

public final class SolutionI implements Solution {

  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    if (s == null) {
      return 0;
    }
    int longest = 0, curLeft = 0;
    final Map<Character, Integer> charCount = new HashMap<>();
    for (int right = 0; right < s.length(); right++) {
      final char rightChar = s.charAt(right);
      charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);

      while (charCount.size() > k) {
        final char leftChar = s.charAt(curLeft);
        final int prevCount = charCount.get(leftChar);
        if (prevCount == 1) {
          charCount.remove(leftChar);
        } else {
          charCount.put(leftChar, prevCount - 1);
        }
        curLeft++;
      }
      longest = Math.max(longest, right - curLeft + 1);
    }
    return longest;
  }
}
