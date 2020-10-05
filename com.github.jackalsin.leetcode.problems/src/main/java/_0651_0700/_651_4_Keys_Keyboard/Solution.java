package _0651_0700._651_4_Keys_Keyboard;

/**
 * @author jacka
 * @version 1.0 on 10/31/2017.
 */
public class Solution {

  public int maxA(int N) {
    final int[] maxA = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      maxA[i] = i;
      for (int j = 1; j <= i - 2; j++) {
        maxA[i] = Math.max(maxA[i], (i - j - 1) * maxA[j]);
      }
    }
    return maxA[N];
  }
}
