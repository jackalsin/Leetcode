package interviews.uber.kPalindrome;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 12/11/2019
 */
public final class SolutionI implements Solution {
  @Override
  public boolean canFormKPalindrome(String str, int k) {
    final Map<Character, Integer> charCount = new HashMap<>();
    for (final char chr : str.toCharArray()) {
      charCount.put(chr, charCount.getOrDefault(chr, 0) + 1);
    }
    if (k > str.length()) {
      return false;
    }
    // 至少要这么多个
    int count = 0;
    for (final Map.Entry<Character, Integer> e : charCount.entrySet()) {
      count += e.getValue() % 2;
    }
    return k >= count;
  }

  boolean composeKPalindromes(String s, int k) {
    assert s != null && !s.isEmpty();
    assert k >= 1;
    final Map<Character, Integer> charCount = new HashMap<>();
    for (final char chr : s.toCharArray()) {
      charCount.put(chr, charCount.getOrDefault(chr, 0) + 1);
    }

    if (k > s.length()) {
      return false;
    }
    int atLeastCount = 0;
    for (final Map.Entry<Character, Integer> e : charCount.entrySet()) {
      atLeastCount += e.getValue() % 2;
    }
    return k >= atLeastCount;
  }
}
