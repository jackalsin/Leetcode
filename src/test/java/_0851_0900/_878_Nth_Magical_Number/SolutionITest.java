package _0851_0900._878_Nth_Magical_Number;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

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
    final int N = 1, A = 2, B = 3, expected = 2, actual = solution.nthMagicalNumber(N, A, B);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int N = 4, A = 2, B = 3, expected = 6, actual = solution.nthMagicalNumber(N, A, B);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int N = 5, A = 2, B = 4, expected = 10, actual = solution.nthMagicalNumber(N, A, B);
    assertEquals(expected, actual);

  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int N = 3, A = 6, B = 4, expected = 8, actual = solution.nthMagicalNumber(N, A, B);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    final int N = 1000000000, A = 40000, B = 40000, expected = 999720007, actual = solution.nthMagicalNumber(N, A, B);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase6(Solution solution) {
    final int N = 1000000000, A = 39999, B = 40000, expected = 999860007, actual = solution.nthMagicalNumber(N, A, B);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}