package linkedin._205_Isomorphic_Strings;

/**
 * @author jacka
 * @version 1.0 on 10/21/2017.
 */
public final class SolutionIII implements Solution {
  private static final char INVALID = '\u0000';

  public boolean isIsomorphic(String s, String t) {
    final char[] sMapT = new char[128], tMapS = new char[128];

    for (int i = 0; i < s.length(); ++i) {
      final char sChar = s.charAt(i), tChar = t.charAt(i);
      if (sMapT[sChar] != INVALID && tMapS[tChar] != INVALID) {
        if (sMapT[sChar] != tChar || tMapS[tChar] != sChar) {
          return false;
        }
      } else if (sMapT[sChar] != INVALID || tMapS[tChar] != INVALID) {
        return false;
      } else {
        sMapT[sChar] = tChar;
        tMapS[tChar] = sChar;
      }
    }
    return true;
  }
}
