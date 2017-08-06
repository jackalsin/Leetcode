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
//    return isIsomorphicMapSolution(s, t);
    return isIsomorphicArraySolution(s, t);
  }

  /**
   *
   * @param s
   * @param t
   * @return
   */
  private static boolean isIsomorphicArraySolution(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    // use index + 1 to avoid initialization, like 'ab' and 'aa'
    int[] sLastSeenPosition = new int[256];
    int[] tLastSeenPosition = new int[256];
    for(int i = 0; i < s.length(); i++) {
      int sLastSeen = sLastSeenPosition[s.charAt(i)];
      int tLastSeen = tLastSeenPosition[t.charAt(i)];
      if (sLastSeen != tLastSeen) {
        return false;
      }
      sLastSeenPosition[s.charAt(i)] = i + 1;
      tLastSeenPosition[t.charAt(i)] = i + 1;
    }
    return true;
  }

  private static boolean isIsomorphicMapSolution(String s, String t) {
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
