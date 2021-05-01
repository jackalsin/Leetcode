package facebook.practice.Matching_Pairs;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 4/30/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int matchingPairs(String s, String t) {
    final char[] sChars = s.toCharArray(),
        tChars = t.toCharArray();
    final int n = s.length();
    final Set<String> misMatch = new HashSet<>();
    int match = 0;
    for (int i = 0; i < n; ++i) {
      if (sChars[i] == tChars[i]) {
        match++;
      } else {
        misMatch.add(sChars[i] + "" + tChars[i]);
      }
    }

    for (final String inorder : misMatch) {
      final String reverse = inorder.charAt(1) + "" + inorder.charAt(0);
      if (misMatch.contains(reverse)) {
        return match + 2;
      }
    }
    if (misMatch.size() == 1) {
      return match - 1;
    }
    if (misMatch.isEmpty()) {
      return match - 2;
    }
    return match;
  }
}
