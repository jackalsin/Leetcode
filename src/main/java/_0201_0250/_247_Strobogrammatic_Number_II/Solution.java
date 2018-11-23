package _0201_0250._247_Strobogrammatic_Number_II;

import java.util.*;

/**
 * @author jacka
 * @version 1.0 on 8/22/2017.
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
  public List<String> findStrobogrammatic(int n) {
    if (n <= 0) {
      return new ArrayList<>();
    } else if (n == 1) {
      return Arrays.asList("0","1", "8");
    } else {
      List<String> result = new ArrayList<>();
      findStrobogrammatic(result, new char[n], 0, n - 1);
      return result;
    }
  }

  private void findStrobogrammatic(List<String> result, char[] chars, int start, int end) {
    if (start > end) {
      result.add(new String(chars));
    } else {
      for (Map.Entry<Character, Character> entry: VALID.entrySet()) {
        char key = entry.getKey(), val = entry.getValue();
        if (start == 0 && key == '0') continue;
        if (start == end && (key != '0' && key != '1' && key != '8')) continue;
        chars[start] = key;
        chars[end] = val;
        findStrobogrammatic(result, chars, start + 1, end - 1);
      }
    }
  }
}
