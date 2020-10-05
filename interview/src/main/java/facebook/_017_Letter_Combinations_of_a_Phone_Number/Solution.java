package facebook._017_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  private static final Map<Character, List<Character>> MAP = new HashMap<>();

  static {
    MAP.put('2', Arrays.asList('a', 'b', 'c'));
    MAP.put('3', Arrays.asList('d', 'e', 'f'));
    MAP.put('4', Arrays.asList('g', 'h', 'i'));
    MAP.put('5', Arrays.asList('j', 'k', 'l'));
    MAP.put('6', Arrays.asList('m', 'n', 'o'));
    MAP.put('7', Arrays.asList('p', 'q', 'r', 's'));
    MAP.put('8', Arrays.asList('t', 'u', 'v'));
    MAP.put('9', Arrays.asList('w', 'x', 'y', 'z'));
  }

  public List<String> letterCombinations(String digits) {
    List<String> res = new ArrayList<>();
    if (digits.isEmpty()) {
      return res;
    }
    res.add("");
    for (char chr : digits.toCharArray()) {
      final List<Character> candidates = MAP.get(chr);
      final List<String> nextRes = new ArrayList<>();
      for (char candidate : candidates) {
        for (String prev : res) {
          nextRes.add(prev + candidate);
        }
      }
      res = nextRes;
    }
    return res;
  }
}
