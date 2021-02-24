package assertions._1054_Distant_Barcodes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author jacka
 * @version 1.0 on 10/31/2020
 */
public final class Assertions {
  private Assertions() {
  }

  public static void assertEquals(final int[] expected, final int[] actual) {
    if (expected == null && actual == null) {
      return;
    }
    if (expected == null) {
      fail("expected is null while actual is " + Arrays.toString(actual));
    }
    if (actual == null) {
      fail("actual is null while expected is " + Arrays.toString(expected));
    }
    final Map<Integer, Integer> expectedCount = getCount(expected), actualCount = getCount(actual);
    org.junit.jupiter.api.Assertions.assertEquals(expectedCount, actualCount, "element count doesn't match");
    // validate no adjacent duplicate
    for (int i = 1; i < actual.length; ++i) {
      assertNotEquals(actual[i], actual[i - 1], "Found duplication in actual = " +
          Arrays.toString(actual) + " at i = " + i);
    }
  }

  private static Map<Integer, Integer> getCount(final int[] actual) {
    final Map<Integer, Integer> result = new HashMap<>();
    for (int a : actual) {
      result.put(a, result.getOrDefault(a, 0) + 1);
    }
    return result;
  }
}
