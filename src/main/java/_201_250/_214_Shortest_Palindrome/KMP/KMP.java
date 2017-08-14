package _201_250._214_Shortest_Palindrome.KMP;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 8/13/2017.
 */
public class KMP {

  private static final int NOT_FOUND = -1;
  private final int[] next;
  private final String pattern;
  private final int pLen;

  public KMP(String pattern) {
    this.pattern = pattern;
    pLen = pattern.length();
    next = genNext(pattern);
  }

  public static int[] genNext(String pattern) {
    int k = -1, j = 0;
    int[] next = new int[pattern.length()];
    next[0] = -1;
    while (j < pattern.length() - 1) { // range check
      if (k == -1 || pattern.charAt(k) == pattern.charAt(j)) { // k是前缀， j是后缀
        ++k;
        ++j;
        next[j] = k;
      } else { // mismatch: 相当于“ABCDABD”的D（此时，k=1, j = 5）是在Search的时候爆掉了，要回去
        k = next[k];
      }
    }
    return next;
  }

  public int search(String s) {
    int i = 0, j = 0;
    while (i < s.length() && j < next.length) {
      if (s.charAt(i) == pattern.charAt(j)) {
        i++;
        j++;
      } else {
        j = next[j];
      }
    }
    if (j == pLen) {
      return i - pLen;
    } else {
      return NOT_FOUND;
    }
  }

  public static void main(String[] args) {
    final String pattern = "ABCDABD";
    final String input = "ABCDABCDABD";
    KMP kmp = new KMP(pattern);
    System.out.println(kmp.search(input) + " should equal to 4");
  }
}
