package _201_250._205_Isomorphic_Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/6/2017.
 */
public class Solution {
  /**
   * Record last seen position.
   * @param s
   * @param t
   * @return
   */
  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    Map<Character, Integer> sLastSeenPosition = new HashMap<>();
    Map<Character, Integer> tLastSeenPosition = new HashMap<>();
    for (int i = 0; i < s.length(); ++i) {
      int sLastSeen = sLastSeenPosition.getOrDefault(s.charAt(i), -1);
      int tLastSeen = tLastSeenPosition.getOrDefault(t.charAt(i), -1);
      if (sLastSeen != tLastSeen) {
        return false;
      }
      sLastSeenPosition.put(s.charAt(i), i);
      tLastSeenPosition.put(t.charAt(i), i);
    }
    return true;
  }
}
