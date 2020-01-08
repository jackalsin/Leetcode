package interviews.uber._267_Palindrome_Permutation_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 1/8/2020
 */
public final class SolutionI implements Solution {
  @Override
  public List<String> generatePalindromes(String s) {
    final Map<Character, Integer> charCounts = new HashMap<>();
    for (char chr : s.toCharArray()) {
      charCounts.put(chr, charCounts.getOrDefault(chr, 0) + 1);
    }
    int oddCount = 0;
    Character oddChar = null;
    for (final Map.Entry<Character, Integer> e : charCounts.entrySet()) {
      final char chr = e.getKey();
      final int count = e.getValue();
      if (count % 2 != 0) {
        oddChar = chr;
        oddCount++;
        if (oddCount > 1) return new ArrayList<>();
      }
    }
    if (oddCount == 1) {
      charCounts.put(oddChar, charCounts.get(oddChar) - 1);
    }
    final List<String> sides = new ArrayList<>();
    getSide(sides, s.length() / 2, charCounts, new StringBuilder());
    final List<String> result = new ArrayList<>();
    for (final String side : sides) {
      final StringBuilder left = new StringBuilder(side);
      final StringBuilder right = new StringBuilder(side).reverse();
      result.add(left.append(oddCount == 1 ? oddChar : "").append(right).toString());
    }
    return result;
  }

  private static void getSide(final List<String> result, final int targetLen, final Map<Character, Integer> charCounts,
                              final StringBuilder sb) {
    if (sb.length() == targetLen) {
      result.add(sb.toString());
      return;
    }
    final int len = sb.length();
    for (final Map.Entry<Character, Integer> e : charCounts.entrySet()) {
      final char chr = e.getKey();
      final int count = e.getValue();
      if (count > 0) {
        sb.append(chr);
        e.setValue(count - 2);
        getSide(result, targetLen, charCounts, sb);
        e.setValue(count);
        sb.setLength(len);
      }
    }
  }

}
