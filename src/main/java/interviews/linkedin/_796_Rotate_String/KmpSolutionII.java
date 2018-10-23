package interviews.linkedin._796_Rotate_String;

public final class KmpSolutionII implements Solution {

  @Override
  public boolean rotateString(String A, String B) {
    if (A.length() != B.length()) {
      return false;
    }
    final String s = A + A, p = B;
    final int[] next = getNext(p);
    int pIndex = 0;
    for (int sIndex = 0; sIndex < s.length() && pIndex < p.length(); ) {
      if (pIndex == -1 || s.charAt(sIndex) == p.charAt(pIndex)) {
        ++sIndex;
        ++pIndex;
      } else {
        pIndex = next[pIndex];
      }
    }

    return pIndex == p.length();
  }

  static int[] getNext(final String p) {
    if (p.length() == 0) {
      return new int[0];
    }
    final int[] next = new int[p.length()];
    next[0] = -1;
    for (int k = -1, j = 0; j < p.length() - 1; ) {
      if (k == -1 || p.charAt(j) == p.charAt(k)) {
        ++k;
        ++j;
        next[j] = k;
      } else {
        k = next[k];
      }
    }

    return next;
  }

}
