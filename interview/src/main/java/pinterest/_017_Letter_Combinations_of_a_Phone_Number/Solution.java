package pinterest._017_Letter_Combinations_of_a_Phone_Number;

import java.util.*;

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
    List<String> prev = new ArrayList<>();
    if (digits == null || digits.isEmpty()) {
      return prev;
    }
    prev.add("");
    for (int i = 0; i < digits.length(); i++) {
      final List<Character> candidates = MAP.get(digits.charAt(i));
      final List<String> curResult = new ArrayList<>();
      for (char chr : candidates) {
        for (String prefix : prev) {
          curResult.add(prefix + chr);
        }
      }
      prev = curResult;
    }
    return prev;
  }
}
