package definition._767_Reorganize_String;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author jacka
 * @version 1.0 on 2/12/2021
 */
public final class Assertions {
  private Assertions() {
  }

  public static void assertValid(final String expect, final String actual) {
    final Map<Character, Integer> expectedCharMap = getCharMap(expect),
        actualCharMap = getCharMap(actual);
    assertEquals(expectedCharMap, actualCharMap);
    for (int i = 1; i < actual.length(); ++i) {
      assertNotEquals(actual.charAt(i), actual.charAt(i - 1),
          "ith and (i - 1)th character is the same in actual = " + actual);
    }
  }

  private static Map<Character, Integer> getCharMap(final String s) {
    final Map<Character, Integer> result = new HashMap<>();
    for (final char c : s.toCharArray()) {
      result.put(c, result.getOrDefault(c, 0) + 1);
    }
    return result;
  }
}
