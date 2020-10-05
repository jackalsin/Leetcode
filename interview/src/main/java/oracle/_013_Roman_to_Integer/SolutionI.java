package oracle._013_Roman_to_Integer;

/**
 * @author jacka
 * @version 1.0 on 10/21/2019
 */
public final class SolutionI implements Solution {
  //  I             1
  //  V             5
  //  X             10
  //  L             50
  //  C             100
  //  D             500
  //  M             1000
  public int romanToInt(String s) {
    int result = 0;
    for (int i = 0; i < s.length(); ++i) {
      if (s.startsWith("IV", i)) {
        result -= 1;
      } else if (s.startsWith("IX", i)) {
        result -= 1;
      } else if (s.startsWith("XL", i)) {
        result -= 10;
      } else if (s.startsWith("XC", i)) {
        result -= 10;
      } else if (s.startsWith("CD", i)) {
        result -= 100;
      } else if (s.startsWith("CM", i)) {
        result -= 100;
      } else if (s.startsWith("I", i)) {
        result += 1;
      } else if (s.startsWith("V", i)) {
        result += 5;
      } else if (s.startsWith("X", i)) {
        result += 10;
      } else if (s.startsWith("L", i)) {
        result += 50;
      } else if (s.startsWith("C", i)) {
        result += 100;
      } else if (s.startsWith("D", i)) {
        result += 500;
      } else if (s.startsWith("M", i)) {
        result += 1000;
      } else {
        throw new IllegalArgumentException("Invalid s = " + s + ", i = " + i);
      }
    }
    return result;
  }
}
