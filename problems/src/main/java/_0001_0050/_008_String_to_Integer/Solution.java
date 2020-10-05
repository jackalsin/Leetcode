package _0001_0050._008_String_to_Integer;

/**
 * @author jacka
 * @version 1.0 on 2017/1/13.
 */
public class Solution {

  public int myAtoi(String str) {
    if (str == null) {
      return 0;
    }
    str = str.trim();
    if (str.isEmpty()) {
      return 0;
    }
    if (str.startsWith("-")) {
      return myAtoiHelper(-1, str.substring(1));
    } else if (str.startsWith("+")) {
      return myAtoiHelper(1, str.substring(1));
    }
    return myAtoiHelper(1, str);
  }

  private int myAtoiHelper(int sign, String substring) {
    int base = 0;
    int i = 0;
    while (i < substring.length()) {
      char chr = substring.charAt(i);
      if (chr >= '0' && chr <= '9') {
        if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && chr >= '8')) {
          return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        base = base * 10 + (int) chr - (int) '0';
      } else {
        return sign * base;
      }
      i++;
    }

    return sign * base;
  }

}