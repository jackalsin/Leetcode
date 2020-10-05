package oracle._003_Longest_Substring_Without_Repeating_Characters;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 10/22/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int lengthOfLongestSubstring(String s) {
    final Set<Character> charSet = new HashSet<>();
    int max = 0;
    for (int left = 0, right = 0; right < s.length(); right++) {
      final char chr = s.charAt(right);
      while (charSet.contains(chr)) {
        final char leftChar = s.charAt(left);
        charSet.remove(leftChar);
        left++;
      }
      charSet.add(chr);
      max = Math.max(max, right - left + 1);
    }
    return max;
  }
}
