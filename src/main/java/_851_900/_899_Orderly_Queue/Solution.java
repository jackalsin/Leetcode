package _851_900._899_Orderly_Queue;

import java.util.Arrays;

public class Solution {

  /**
   * Time Complexity: o(N ^ 2)
   *
   * @param S
   * @param K
   * @return
   */
  public String orderlyQueue(String S, int K) {
    if (K > 1) {
      final char[] chars = S.toCharArray();
      Arrays.sort(chars);
      return String.valueOf(chars);
    }

    String minS = S;
    for (int i = 1; i < S.length(); ++i) {
      String cand = S.substring(i) + S.substring(0, i);
      minS = cand.compareTo(minS) < 0 ? cand : minS;
    }
    return minS;
  }

}
