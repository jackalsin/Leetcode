package linkedin._017_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class SolutionII implements Solution {
  private static final Map<Character, List<Character>> MAP = Map.of(
      '2', List.of('a', 'b', 'c'),
      '3', List.of('d', 'e', 'f'),
      '4', List.of('g', 'h', 'i'),
      '5', List.of('j', 'k', 'l'),
      '6', List.of('m', 'n', 'o'),
      '7', List.of('p', 'q', 'r', 's'),
      '8', List.of('t', 'u', 'v'),
      '9', List.of('w', 'x', 'y', 'z')
  );

  public List<String> letterCombinations(String digits) {
    final List<String> result = new ArrayList<>();
    if (digits == null || digits.isEmpty()) return result;
    dfs(result, new StringBuilder(), digits, 0);
    return result;
  }

  private static void dfs(final List<String> result, final StringBuilder sb,
                          final String digit, final int i) {
    if (i == digit.length()) {
      result.add(sb.toString());
      return;
    }
    final int len = sb.length();
    final List<Character> candidates = MAP.get(digit.charAt(i));
    for (final char c : candidates) {
      sb.append(c);
      dfs(result, sb, digit, i + 1);
      sb.setLength(len);
    }
  }
}
