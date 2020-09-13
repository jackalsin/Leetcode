package _0851_0900._870_Advantage_Shuffle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/13/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] A = {2, 7, 11, 15}, B = {1, 10, 4, 11},
        actual = solution.advantageCount(A, B),
        expected = {2, 11, 7, 15};
    assertAdvantage(expected, actual, B);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] A = {12, 24, 8, 32}, B = {13, 25, 32, 11},
        actual = solution.advantageCount(A, B), expected = {24, 32, 8, 12};
    assertAdvantage(expected, actual, B);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[] A = {2, 0, 4, 1, 2}, B = {1, 3, 0, 0, 2},
        actual = solution.advantageCount(A, B), expected = {2, 0, 2, 1, 4};
    assertAdvantage(expected, actual, B);
  }

  private static void assertAdvantage(final int[] expectSample, final int[] a, final int[] b) {
    assertEquals(a.length, b.length);
    int actual = 0, expected = 0;
    for (int i = 0; i < a.length; ++i) {
      if (a[i] > b[i]) actual++;
      if (expectSample[i] > b[i]) expected++;
    }
    assertEquals(expected, actual, "Found count of entries where A[i] > B[i] " + actual +
        " for A = " + Arrays.toString(a));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}