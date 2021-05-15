package example.string;

/**
 * @author jacka
 * @version 1.0 on 5/12/2021
 */
public final class KMPIII implements KMP {
  @Override
  public int substring(String s, String p) {
    final int[] next = getNext(p);
    int i = 0, j = 0;
    for (; i < s.length() && j < p.length(); ) {
      if (j == -1 || s.charAt(i) == p.charAt(j)) {
        ++i;
        ++j;
      } else {
        j = next[j];
      }
    }
    if (j == p.length()) return i - j;
    return -1;
  }

  @Override
  public int[] getNext(String pattern) {
    if (pattern.isEmpty()) return new int[0];
    final int n = pattern.length();
    final int[] next = new int[n];
    next[0] = -1;
    for (int j = 0, k = -1; j < n - 1; ) {
      if (k == -1 || pattern.charAt(j) == pattern.charAt(k)) {
        k++;
        j++;
        next[j] = k;
      } else {
        k = next[k];
      }
    }
    return next;
  }
}
