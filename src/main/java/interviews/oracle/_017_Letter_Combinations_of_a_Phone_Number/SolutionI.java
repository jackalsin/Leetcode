package interviews.oracle._017_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/21/2019
 */
public final class SolutionI implements Solution {
  private static final List<List<Character>> PHONE_NUMBER = new ArrayList<List<Character>>() {{
    add(Arrays.asList()); // 0
    add(Arrays.asList()); // 1
    add(Arrays.asList('a', 'b', 'c')); // 2
    add(Arrays.asList('d', 'e', 'f')); // 3
    add(Arrays.asList('g', 'h', 'i')); // 4
    add(Arrays.asList('j', 'k', 'l')); // 5
    add(Arrays.asList('m', 'n', 'o')); // 6
    add(Arrays.asList('p', 'q', 'r', 's')); // 7
    add(Arrays.asList('t', 'u', 'v')); // 8
    add(Arrays.asList('w', 'x', 'y', 'z')); // 9
  }};

  public List<String> letterCombinations(String digits) {
    final List<String> result = new ArrayList<>();
    if (digits == null || digits.length() == 0) {
      return result;
    }
    final StringBuilder sb = new StringBuilder();
    letterCombinations(result, sb, digits, 0);
    return result;
  }

  private static void letterCombinations(final List<String> result, final StringBuilder sb, final String digits,
                                         int i) {
    if (i == digits.length()) {
      result.add(sb.toString());
      return;
    }
    final int len = sb.length();
    for (char chr : PHONE_NUMBER.get(digits.charAt(i) - '0')) {
      sb.append(chr);
      letterCombinations(result, sb, digits, i + 1);
      sb.setLength(len);
    }
  }
}
