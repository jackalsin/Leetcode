package _0801_0850._838_Push_Dominoes;

/**
 * @author jacka
 * @version 1.0 on 9/2/2020
 */
public final class ThreePassSolution implements Solution {
  private static final char L = 'L', R = 'R', DOT = '.';

  public String pushDominoes(String dominoes) {
    final char[] chars = dominoes.toCharArray();
    final int n = chars.length;
    // 这题就是看到 L 和 R 的最短距离
    final int[] toL = new int[n],
        toR = new int[n];
    int distance = Integer.MAX_VALUE;
    for (int i = 0; i < n; ++i) {
      final char chr = chars[i];
      if (chr == R) {
        distance = 0;
      } else if (chr == L) {
        distance = Integer.MAX_VALUE;
      } else {
        if (distance != Integer.MAX_VALUE) distance++;
        toR[i] = distance;
      }
    }

    distance = Integer.MAX_VALUE;
    for (int i = n - 1; i >= 0; --i) {
      final char chr = chars[i];
      if (chr == L) {
        distance = 0;
      } else if (chr == R) {
        distance = Integer.MAX_VALUE;
      } else {
        if (distance != Integer.MAX_VALUE) distance++;
        toL[i] = distance;
      }
    }
//    System.out.println(Arrays.toString(toL));
//    System.out.println(Arrays.toString(toR));
    for (int i = 0; i < n; ++i) {
      final char chr = chars[i];
      if (chr == DOT) {
        if (toL[i] > toR[i]) {
          chars[i] = R;
        } else if (toL[i] == toR[i]) {
          chars[i] = DOT;
        } else {
          chars[i] = L;
        }
      }
    }
    return String.valueOf(chars);
  }
}
