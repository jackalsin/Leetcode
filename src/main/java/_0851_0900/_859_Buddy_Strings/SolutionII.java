package _0851_0900._859_Buddy_Strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 9/12/2020
 */
public final class SolutionII implements Solution {
  @Override
  public boolean buddyStrings(String A, String B) {
    if (A == null || B == null || A.length() != B.length()) {
      return false;
    }
    if (A.equals(B)) {
      // equals and has duplicate
      final Set<Character> visited = new HashSet<>();
      for (final char chr : A.toCharArray()) {
        if (!visited.add(chr)) {
          return true;
        }
      }
      return false;
    }
    final int len = A.length();
    final List<Integer> diff = new ArrayList<>();
    for (int i = 0; i < len; ++i) {
      if (A.charAt(i) == B.charAt(i)) continue;
      diff.add(i);
      if (diff.size() > 2) return false;
    }
    return diff.size() == 2 &&
        A.charAt(diff.get(0)) == B.charAt(diff.get(1)) &&
        B.charAt(diff.get(0)) == A.charAt(diff.get(1));
  }
}
