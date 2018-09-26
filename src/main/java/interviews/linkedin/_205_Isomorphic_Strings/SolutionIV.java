package interviews.linkedin._205_Isomorphic_Strings;

import java.util.HashMap;
import java.util.Map;

public final class SolutionIV implements Solution {
  @Override
  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    final Map<Character, Character> map = new HashMap<>();
    final boolean[] alreadyMapped = new boolean[256];
    for (int i = 0; i < s.length(); ++i) {
      final char sChar = s.charAt(i), tChar = t.charAt(i);
      if (map.containsKey(sChar)) {
        if (map.get(sChar) != tChar) {
          return false;
        }
      } else {
        map.put(sChar, tChar);
        if (alreadyMapped[tChar]) {
          return false;
        }
        alreadyMapped[tChar] = true;
      }

    }

    return true;
  }
}
