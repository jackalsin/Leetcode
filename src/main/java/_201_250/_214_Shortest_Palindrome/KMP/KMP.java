package _201_250._214_Shortest_Palindrome.KMP;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 8/13/2017.
 */
public class KMP {

  public static int[] genNext(String pattern) {
    int k = -1, j = 0;
    int[] next = new int[pattern.length()];
    next[0] = -1;
    while (j < pattern.length() - 1) { // range check
      if (k == -1 || pattern.charAt(k) == pattern.charAt(j)) {
        ++k;
        ++j;
        next[j] = k;
      } else {
        k = next[k];
      }
    }
    return next;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(genNext("ABCDABD")));
  }
}
