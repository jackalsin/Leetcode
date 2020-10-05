package facebook._013_Roman_to_Integer;

public class Solution {

  private static final int I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000;

  public int romanToInt(String s) {
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.startsWith("IX", i) || s.startsWith("IV", i)) {
        res -= 1;
      } else if (s.startsWith("XL", i) || s.startsWith("XC", i)) {
        res -= 10;
      } else if (s.startsWith("CD", i) || s.startsWith("CM", i)) {
        res -= 100;
      } else {
        final char chr = s.charAt(i);
        switch (chr) {
          case 'I':
            res += I;
            break;
          case 'V':
            res += V;
            break;
          case 'X':
            res += X;
            break;
          case 'L':
            res += L;
            break;
          case 'C':
            res += C;
            break;
          case 'D':
            res += D;
            break;
          case 'M':
            res += M;
            break;
        }
      }
    }
    return res;
  }
}
