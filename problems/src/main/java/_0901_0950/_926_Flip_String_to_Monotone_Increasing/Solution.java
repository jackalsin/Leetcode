package _0901_0950._926_Flip_String_to_Monotone_Increasing;

public class Solution {
  public int minFlipsMonoIncr(String S) {
    final char[] chars = S.toCharArray();
    final int[][] ends = new int[2][S.length() + 1];
    for (int i = 0; i < chars.length; i++) {
      final char chr = chars[i];
      if (chr == '0') {
        ends[0][i + 1] = ends[0][i];
        ends[1][i + 1] = Math.min(ends[0][i], ends[1][i]) + 1;
      } else if (chr == '1') {
        ends[0][i + 1] = ends[0][i] + 1;
        ends[1][i + 1] = Math.min(ends[0][i], ends[1][i]);
      }
    }

//    display(ends);
    return Math.min(ends[0][S.length()], ends[1][S.length()]);
  }
}
