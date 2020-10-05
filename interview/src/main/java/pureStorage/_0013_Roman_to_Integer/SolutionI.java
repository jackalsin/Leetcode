package pureStorage._0013_Roman_to_Integer;

public final class SolutionI implements Solution {
  public int romanToInt(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    int res = 0;
    for (int i = 0; i < s.length(); ++i) {
      if (s.startsWith("IV", i)) {
        --res;
      } else if (s.startsWith("IX", i)) {
        --res;
      } else if (s.startsWith("XL", i)) {
        res -= 10;
      } else if (s.startsWith("XC", i)) {
        res -= 10;
      } else if (s.startsWith("CD", i)) {
        res -= 100;
      } else if (s.startsWith("CM", i)) {
        res -= 100;
      } else if (s.startsWith("I", i)) {
        res++;
      } else if (s.startsWith("V", i)) {
        res += 5;
      } else if (s.startsWith("X", i)) {
        res += 10;
      } else if (s.startsWith("L", i)) {
        res += 50;
      } else if (s.startsWith("C", i)) {
        res += 100;
      } else if (s.startsWith("D", i)) {
        res += 500;
      } else if (s.startsWith("M", i)) {
        res += 1000;
      } else {
        throw new IllegalStateException();
      }
    }
    return res;
  }
}
