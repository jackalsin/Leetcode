package dropbox._017_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 5/23/2021
 */
public final class SolutionI implements Solution {
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
    if (digits == null || digits.isEmpty()) return Collections.emptyList();
    final List<String> result = new ArrayList<>();
    letterCombinations(result, digits.toCharArray(), 0, new StringBuilder());
    return result;
  }

  private void letterCombinations(final List<String> result, final char[] digits, final int i,
                                  final StringBuilder sb) {
    if (i == digits.length) {
      result.add(sb.toString());
      return;
    }
    final int len = sb.length();
    final List<Character> children = MAP.get(digits[i]);
    for (final char c : children) {
      sb.append(c);
      letterCombinations(result, digits, i + 1, sb);
      sb.setLength(len);
    }
  }
}
