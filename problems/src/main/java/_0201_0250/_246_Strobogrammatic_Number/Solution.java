package _0201_0250._246_Strobogrammatic_Number;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/21/2017.
 */
public class Solution {
  private static final Map<Character, Character> VALID = new HashMap<>();
  static {
    VALID.put('0', '0');
    VALID.put('1', '1');
    VALID.put('6', '9');
    VALID.put('8', '8');
    VALID.put('9', '6');
  }
  /**
   * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
   * Write a function to determine if a number is strobogrammatic. The number is represented as a
   * string.
   * For example, the numbers "69", "88", and "818" are all strobogrammatic.
   *
   * Based on the test, seems only positive
   * @param num
   * @return
   */
  public boolean isStrobogrammatic(String num) {
    int start = 0, end = num.length() - 1;
    char[] chars = num.toCharArray();
    while (start <= end) {
      if (chars[start] != VALID.getOrDefault(chars[end], '\0')) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }
}
