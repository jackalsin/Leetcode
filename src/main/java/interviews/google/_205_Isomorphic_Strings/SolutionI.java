package interviews.google._205_Isomorphic_Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/14/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean isIsomorphic(String s, String t) {
    final Map<Character, Character> tToS = new HashMap<>(),
        sToT = new HashMap<>();
    final char[] sChars = s.toCharArray(),
        tChars = t.toCharArray();
    for (int i = 0; i < s.length(); ++i) {
      final char tChar = tChars[i],
          sChar = sChars[i],
          expectedSChar = tToS.getOrDefault(tChar, sChar),
          expectedTChar = sToT.getOrDefault(sChar, tChar);
      if (expectedSChar != sChar || expectedTChar != tChar) {
        return false;
      }
      tToS.put(tChar, sChar);
      sToT.put(sChar, tChar);
    }
    return true;
  }
}
