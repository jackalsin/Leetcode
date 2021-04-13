package lime._017_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/12/2021
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
    if (digits == null || digits.length() == 0) {
      return Collections.emptyList();
    }
    final StringBuilder curPath = new StringBuilder();
    final List<String> result = new ArrayList<>();
    letterCombination(result, curPath, digits, 0);
    return result;
  }

  private void letterCombination(final List<String> result, final StringBuilder curPath,
                                 final String digits, final int i) {
    if (digits.length() == i) {
      result.add(curPath.toString());
      return;
    }
    final char chr = digits.charAt(i);
    final List<Character> children = MAP.getOrDefault(chr, Collections.emptyList());
    for (final char next : children) {
      curPath.append(next);
      letterCombination(result, curPath, digits, i + 1);
      curPath.setLength(i);
    }
  }
}
