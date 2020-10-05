package utils._358_Rearrange_String_k_Distance_Apart;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author jacka
 * @version 1.0 on 12/22/2019
 */
public final class Assertions {
  public static void assertTrue(final String actual, final String src, final int k) {
    final Map<Character, Integer> actualCharMap = getCharMap(actual),
        srcCharMap = getCharMap(src);
    assertEquals(srcCharMap, actualCharMap,
        "actual = " + actual + "charMap is not equals, src char map = " + srcCharMap +
            ", actual char map = " + actualCharMap);

    final LinkedHashSet<Character> q = new LinkedHashSet<>();
    for (int i = 0; i < k; i++) {
      final char chr = actual.charAt(i);
      if (q.contains(chr)) {
        fail("actual = " + actual + ", char = " + chr + " in k part = " + q + ", i = " + i);
      }
      q.add(chr);
    }
    for (int i = k; i < src.length(); ++i) {
      // remove the first one
      final char firstChar = q.iterator().next();
      q.remove(firstChar);
      final char chr = actual.charAt(i);
      if (q.contains(chr)) {
        fail("actual = " + actual + ", char = " + chr + " in k part = " + q + ", i = " + i);
      }
      q.add(chr);
    }
  }

  private static Map<Character, Integer> getCharMap(final String src) {
    final Map<Character, Integer> result = new HashMap<>();
    for (char chr : src.toCharArray()) {
      result.put(chr, result.getOrDefault(chr, 0) + 1);
    }
    return result;
  }
}
