package _0401_0450._405_Convert_a_Number_to_Hexadecimal;

import java.util.Arrays;

public class Solution {
  private static final char[] map = new char[16];

  static {
    for (int i = 0; i <= 9; i++) {
      map[i] = (char) ('0' + i);
    }
    for (int i = 10; i <= 15; i++) {
      map[i] = (char) ('a' + i - 10);
    }
    System.out.println(Arrays.toString(map));
  }

  public String toHex(int num) {
    if (num == 0) {
      return "0";
    }
    final StringBuilder sb = new StringBuilder();
    while (num != 0) {
      sb.append(map[(num & 0b1111)]);
      num >>>= 4;
    }
    return sb.reverse().toString();
  }
}
