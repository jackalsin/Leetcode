package interviews.linkedin._205_Isomorphic_Strings;

/**
 * @author jacka
 * @version 1.0 on 10/21/2017.
 */
public final class SolutionII implements Solution {
  private static final char INVALID = '\u0000';

  public boolean isIsomorphic(String s, String t) {
    if (s == null && t == null) {
      return true;
    } else if (s == null || t == null) {
      return false;
    }
    if (s.length() != t.length()) {
      return false;
    }

    final char[] sToT = new char[128], tToS = new char[128];
    for (int i = 0; i < s.length(); i++) {
      final char sChar = s.charAt(i), tChar = t.charAt(i);
      if (sToT[sChar] == INVALID && tToS[tChar] == INVALID) {
        sToT[sChar] = tChar;
        tToS[tChar] = sChar;
      } else if (sToT[sChar] == INVALID || tToS[tChar] == INVALID) {
        return false;
      } else {
        // mapping exist
        if (sToT[sChar] != tChar || tToS[tChar] != sChar) {
          return false;
        }
      }
    }

    return true;
  }
}
