package interviews.uber._013_Roman_to_Integer;

/**
 * @author jacka
 * @version 1.0 on 2/12/2018.
 */
public class Solution {
  private static final int V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000;

  public int romanToInt(String s) {
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.startsWith("IV", i)) {
        result--;
      } else if (s.startsWith("IX", i)) {
        result--;
      } else if (s.startsWith("XL", i)) {
        result -= 10;
      } else if (s.startsWith("XC", i)) {
        result -= 10;
      } else if (s.startsWith("CD", i)) {
        result -= 100;
      } else if (s.startsWith("CM", i)) {
        result -= 100;
      } else if (s.startsWith("I", i)) {
        result++;
      } else if (s.startsWith("V", i)) {
        result += V;
      } else if (s.startsWith("X", i)) {
        result += X;
      } else if (s.startsWith("L", i)) {
        result += L;
      } else if (s.startsWith("C", i)) {
        result += C;
      } else if (s.startsWith("D", i)) {
        result += D;
      } else if (s.startsWith("M", i)) {
        result += M;
      } else {
        throw new IllegalStateException("Unexpected token = " + s.charAt(i));
      }
    }

    return result;
  }
}
