package linkedin._017_Letter_Combinations_of_a_Phone_Number;

import java.util.*;

public class Solution {
  private final Map<Character, List<Character>> map = new HashMap<>();

  {
    map.put('2', Arrays.asList('a', 'b', 'c'));
    map.put('3', Arrays.asList('d', 'e', 'f'));
    map.put('4', Arrays.asList('g', 'h', 'i'));
    map.put('5', Arrays.asList('j', 'k', 'l'));
    map.put('6', Arrays.asList('m', 'n', 'o'));
    map.put('7', Arrays.asList('p', 'q', 'r', 's'));
    map.put('8', Arrays.asList('t', 'u', 'v'));
    map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
  }

  public List<String> letterCombinations(String digits) {
    if (digits == null || digits.length() == 0) {
      return new ArrayList<>();
    }
    final char[] chars = digits.toCharArray();
    final List<String> result = new ArrayList<>();
    dfs(result, "", chars, 0);
    return result;
  }

  private void dfs(final List<String> result, String curPath, final char[] chars, final int i) {
    if (i == chars.length) {
      result.add(curPath);
      return;
    }

    final List<Character> candidates = map.get(chars[i]);
    for (char chr : candidates) {
      dfs(result, curPath + chr, chars, i + 1);
    }
  }
}
