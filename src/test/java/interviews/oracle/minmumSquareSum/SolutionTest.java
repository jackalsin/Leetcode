package interviews.oracle.minmumSquareSum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/26/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    assertEquals(1, solution.getMinSquareSum(1));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase16(Solution solution) {
    assertEquals(1, solution.getMinSquareSum(16));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase22(Solution solution) {
    // 4 + 9 + 9
    assertEquals(4, solution.getMinSquareSum(22));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase100(Solution solution) {
    assertEquals(1, solution.getMinSquareSum(100));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase10(Solution solution) {
    assertEquals(2, solution.getMinSquareSum(10));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new DpSolution()
    );
  }
}