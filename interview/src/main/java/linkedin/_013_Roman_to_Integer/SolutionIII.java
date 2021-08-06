package linkedin._013_Roman_to_Integer;

public final class SolutionIII implements Solution {
  //  Symbol       Value
//  I             1
//  V             5
//  X             10
//  L             50
//  C             100
//  D             500
//  M             1000
  public int romanToInt(String s) {
    int sum = 0;
    for (int i = 0; i < s.length(); ++i) {
      if (s.startsWith("IV", i) || s.startsWith("IX", i)) {
        sum -= 1;
      } else if (s.startsWith("XL", i) || s.startsWith("XC", i)) {
        sum -= 10;
      } else if (s.startsWith("CD", i) || s.startsWith("CM", i)) {
        sum -= 100;
      } else if (s.startsWith("I", i)) {
        sum += 1;
      } else if (s.startsWith("V", i)) {
        sum += 5;
      } else if (s.startsWith("X", i)) {
        sum += 10;
      } else if (s.startsWith("L", i)) {
        sum += 50;
      } else if (s.startsWith("C", i)) {
        sum += 100;
      } else if (s.startsWith("D", i)) {
        sum += 500;
      } else if (s.startsWith("M", i)) {
        sum += 1000;
      }
    }
    return sum;
  }
}
