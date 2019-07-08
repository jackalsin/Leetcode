package interviews.linkedin._205_Isomorphic_Strings;

public final class SolutionIV implements Solution {
  private static final int N = 256;

  public boolean isIsomorphic(String sString, String tString) {
    if (sString == null && tString == null) {
      return true;
    } else if (sString == null || tString == null) {
      return false;
    }

    assert sString.length() == tString.length();
    final char[] sToT = new char[N], tToS = new char[N];
    final char[] s = sString.toCharArray(), t = tString.toCharArray();
    for (int i = 0; i < s.length; i++) {
      final char sChar = s[i], tChar = t[i];
      if (sToT[sChar] != 0 && tToS[tChar] != 0) {
        if (sToT[sChar] != tChar || tToS[tChar] != sChar) {
          return false;
        }
      } else if (sToT[sChar] != 0 || tToS[tChar] != 0) {
        return false;
      } else {
        sToT[sChar] = tChar;
        tToS[tChar] = sChar;
      }
    }
    return true;
  }
}
