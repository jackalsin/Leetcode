package interviews.facebook._028_Implement_strStr;

public class Solution {
  public int strStr(String s, String p) {
    final int[] next = getNext(p);
    final int sLen = s.length(), pLen = p.length();
    int i = 0, j = 0;
    while (i < sLen && j < pLen) {
      if (j == -1 || s.charAt(i) == p.charAt(j)) {
        ++i;
        ++j;
      } else {
        j = next[j];
      }
    }
    if (j == pLen) {
      return i - j;
    } else {
      return -1; // not found
    }
  }

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
