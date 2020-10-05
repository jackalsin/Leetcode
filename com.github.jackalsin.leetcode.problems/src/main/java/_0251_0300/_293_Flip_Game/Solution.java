package _0251_0300._293_Flip_Game;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/6/2017.
 */
public class Solution {
  public List<String> generatePossibleNextMoves(String s) {
    if (s.length() < 2) return new ArrayList<>();
    else {
      List<String> result = new ArrayList<>();
      char[] chars = s.toCharArray();
      for (int i = 1; i < chars.length; i++) {
        if (chars[i] == chars[i - 1]) {
          if (chars[i] == '+') {
            chars[i] = '-';
            chars[i - 1] = '-';
            appendResult(result, chars);
            chars[i] = '+';
            chars[i - 1] = '+';
          }
        }
      }
      return result;
    }
  }

  private static void appendResult(List<String> result, char[] chars) {
    result.add(new String(chars));
  }
}
