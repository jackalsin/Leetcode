package _0851_0900._859_Buddy_Strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 8/18/2019
 */
public final class SolutionI implements Solution {
  public boolean buddyStrings(String A, String B) {
    if (A == null || B == null || A.length() != B.length()) {
      return false;
    }
    final char[] a = A.toCharArray(), b = B.toCharArray();
    if (A.equals(B)) { // check duplicate char
      final Set<Character> set = new HashSet<>();
      for (final char chr : a) {
        set.add(chr);
      }
      return set.size() < A.length();
    }
    // no equals
    final List<Integer> diff = new ArrayList<>();
    for (int i = 0; i < a.length; ++i) {
      if (a[i] != b[i]) diff.add(i);
    }
    return diff.size() == 2 && a[diff.get(0)] == b[diff.get(1)] && a[diff.get(1)] == b[diff.get(0)];
  }
}
