package airbnb._1387_Sort_Integers_by_The_Power_Value;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/4/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int lo = 12, hi = 15, k = 2, expected = 13;
    assertEquals(expected, solution.getKth(lo, hi, k));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int lo = 1, hi = 1, k = 1, expected = 1;
    assertEquals(expected, solution.getKth(lo, hi, k));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int lo = 7, hi = 11, k = 4, expected = 7;
    assertEquals(expected, solution.getKth(lo, hi, k));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}