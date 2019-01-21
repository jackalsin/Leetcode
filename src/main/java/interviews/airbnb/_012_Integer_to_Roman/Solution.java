package interviews.airbnb._012_Integer_to_Roman;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  private static final String[][] MAP = {
      {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
      {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"},
      {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM", "M"},
      {"", "M", "MM", "MMM"}
  };

  public String intToRoman(int num) {
    final Deque<String> stack = new ArrayDeque<>();
    assert num > 0;
    for (int i = 0; i < 4; i++) {
      int digit = num % 10;
      num /= 10;
      stack.push(MAP[i][digit]);
    }
    final StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    return sb.toString();
  }
}
