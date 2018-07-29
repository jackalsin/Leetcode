package example.string;

public final class KMP {

  public int substring(final String s, final String p) {
    final int[] next = getNext(p);
    final int sLen = s.length(), pLen = p.length();
    int i = 0, j = 0;
    while (i < sLen && j < pLen) {
      if (j == -1 || s.charAt(i) == p.charAt(j)) {
        // when mismatch
        ++i;
        ++j;
      } else {
        // when match
        j = next[j];
      }
    }

    if (j == pLen) {
      return i - j;
    } else {
      return -1;
    }
  }

  /**
   * Generate the next[] array;
   *
   * @param pattern
   * @return
   */
  static int[] getNext(final String pattern) {
    final int[] next = new int[pattern.length()];
    if (pattern.length() == 0) {
      return next;
    }
    next[0] = -1;
    int k = -1, j = 0;
    while (j < pattern.length() - 1) {
      if (k == -1 || pattern.charAt(j) == pattern.charAt(k)) {
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
