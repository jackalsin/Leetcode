package interviews.microsoft._013_Roman_to_Integer;

public class Solution {
  public int romanToInt(String s) {
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.startsWith("IV", i) || s.startsWith("IX", i)) {
        res -= 1;
      } else if (s.startsWith("XL", i) || s.startsWith("XC", i)) {
        res -= 10;
      } else if (s.startsWith("CD", i) || s.startsWith("CM", i)) {
        res -= 100;
      } else {
        switch (s.charAt(i)) {
          case 'I':
            res += 1;
            break;
          case 'V':
            res += 5;
            break;
          case 'X':
            res += 10;
            break;
          case 'L':
            res += 50;
            break;
          case 'C':
            res += 100;
            break;
          case 'D':
            res += 500;
            break;
          case 'M':
            res += 1000;
            break;
        }
      }
    }
    return res;
  }
}
