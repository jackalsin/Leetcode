package uber._017_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/12/2018.
 */
public class Solution {
  private static final List<List<Character>> MAP = new ArrayList<>();

  static {
    MAP.add(Collections.singletonList(' ')); // 0
    MAP.add(Collections.emptyList()); // 1
    MAP.add(Arrays.asList('a', 'b', 'c'));
    MAP.add(Arrays.asList('d', 'e', 'f'));
    MAP.add(Arrays.asList('g', 'h', 'i'));  // 4
    MAP.add(Arrays.asList('j', 'k', 'l'));  // 5
    MAP.add(Arrays.asList('m', 'n', 'o'));  // 6
    MAP.add(Arrays.asList('p', 'q', 'r', 's'));
    MAP.add(Arrays.asList('t', 'u', 'v'));
    MAP.add(Arrays.asList('w', 'x', 'y', 'z'));

  }

  public List<String> letterCombinations(String digits) {
    final char[] chars = digits.toCharArray();
    List<String> result = new ArrayList<>();
    if (digits.length() == 0) {
      return result;
    }
    result.add("");
    for (char chr : chars) {
      List<String> copy = new ArrayList<>();
      int i = chr - '0';
      for (char next : MAP.get(i)) {
        for (String prev : result) {
          copy.add(prev + next);
        }
      }
      result = copy;
    }
    return result;
  }
}
