package _001_100._008_String_to_Integer;

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
    boolean isAssignedSign = false;
    for (int i = 0; i < substring.length(); i++) {
      base = base * 10 + (int) substring.charAt(i) - (int) '0';
      if (!isAssignedSign && base != 0) {
        base *= sign;
        isAssignedSign = true;
      }
    }
    return base;
  }

}