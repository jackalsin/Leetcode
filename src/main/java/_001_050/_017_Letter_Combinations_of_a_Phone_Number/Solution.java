package _001_050._017_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2017/1/21.
 */
public class Solution {

  private static final Map<Character, List<Character>> MAPPING = new HashMap<>();

  static {
    MAPPING.put('2', Arrays.asList('a', 'b', 'c'));
    MAPPING.put('3', Arrays.asList('d', 'e', 'f'));
    MAPPING.put('4', Arrays.asList('g', 'h', 'i'));
    MAPPING.put('5', Arrays.asList('j', 'k', 'l'));
    MAPPING.put('6', Arrays.asList('m', 'n', 'o'));
    MAPPING.put('7', Arrays.asList('p', 'q', 'r', 's'));
    MAPPING.put('8', Arrays.asList('t', 'u', 'v'));
    MAPPING.put('9', Arrays.asList('w', 'x', 'y', 'z'));
  }

  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if (digits == null || digits.isEmpty()) {
      return result;
    }
    dfsHelper(digits, result, new StringBuilder(), 0);
    return result;
  }

  private void dfsHelper(String digits, List<String> result, StringBuilder curPath, int index) {
    if (index == digits.length()) {
      result.add(curPath.toString());
    } else {
      List<Character> candidates = MAPPING.get(digits.charAt(index));
      if (candidates == null) {
        return;
      }
      for (char candidate : candidates) {
        StringBuilder sb = new StringBuilder(curPath);
        sb.append(candidate);
        dfsHelper(digits, result, sb, index + 1);
      }
    }
  }
}
