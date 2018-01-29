package interviews.google._686_Repeated_String_Match;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 1/29/2018.
 */
public final class KMPSoution implements Solution {
  public int repeatedStringMatch(String a, String b) {
    final int[] prefTable = new int[b.length() + 1]; // 1-based to avoid extra checks.
    for (int sp = 1, pp = 0; sp < b.length(); prefTable[++sp] = pp) {
      pp = b.charAt(pp) == b.charAt(sp) ? pp + 1 : prefTable[pp];
    }
    System.out.println(Arrays.toString(prefTable));
    for (int i = 0, j = 0; i < a.length(); i += Math.max(1, j - prefTable[j]), j = prefTable[j]) {
      while (j < b.length() && a.charAt((i + j) % a.length()) == b.charAt(j)) {
        ++j;
      }
      if (j == b.length()) {
        return (i + j) / a.length() + ((i + j) % a.length() != 0 ? 1 : 0);
      }
    }
    return -1;
  }
}
