package _0451_0500._455_Assign_Cookies;

import java.util.Arrays;

public class Solution {

  public int findContentChildren(int[] g, int[] s) {
    int gI = 0, sI = 0;
    for (final int[] c : new int[][]{g, s}) {
      Arrays.sort(c);
    }
    while (gI < g.length) {
      while (sI < s.length && g[gI] > s[sI]) {
        sI++;
      }
      if (sI == s.length) {
        return gI;
      }
      sI++;
      gI++;
    }
    return gI;
  }
}
