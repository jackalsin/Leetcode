package interviews.microsoft.noodleEssence._340_Longest_Substring_with_At_Most_K_Distinct_Characters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int lengthOfLongestSubstringKDistinct(String s, final int k) {
    int left = 0, maxLen = Math.min(k, s.length()); // check check
    final Map<Character, Integer> charCounts = new HashMap<>();

    for (int right = 0; right < s.length(); right++) {
      final char rightChar = s.charAt(right);
      charCounts.put(rightChar, charCounts.getOrDefault(rightChar, 0) + 1);

      while (left <= right && charCounts.size() > k) {
        final char leftChar = s.charAt(left);
        final int leftCount = charCounts.get(leftChar);
        if (leftCount == 1) {
          charCounts.remove(leftChar);
        } else {
          charCounts.put(leftChar, leftCount - 1);
        }
        left++;
      } // end of while loop
      maxLen = Math.max(right - left + 1, maxLen);
    }

    return maxLen;
  }

}
