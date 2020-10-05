package _0901_0950._905_Sort_Array_By_Parity;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author jacka
 * @version 1.0 on 9/17/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] input = {3, 1, 2, 4}, actual = solution.sortArrayByParity(input);
    assertEquals(getElementCount(input), getElementCount(actual));
    assertIsEvenFirst(actual);
  }

  private static void assertIsEvenFirst(final int[] arr) {
    boolean seenOdd = false;
    for (int a : arr) {
      final boolean isEven = a % 2 == 0;
      if (seenOdd && isEven) {
        fail("actual = " + Arrays.toString(arr));
      }
      seenOdd |= !isEven;
    }
  }

  private static Map<Integer, Integer> getElementCount(final int[] a) {
    final Map<Integer, Integer> result = new HashMap<>();
    for (final var e : a) {
      result.put(e, result.getOrDefault(e, 0) + 1);
    }
    return result;
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}