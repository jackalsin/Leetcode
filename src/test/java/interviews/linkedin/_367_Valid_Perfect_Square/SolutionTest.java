package interviews.linkedin._367_Valid_Perfect_Square;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author jacka
 * @version 1.0 on 10/23/2017.
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void test16Solution(Solution solution) {
    final int num = 16;
    assertTrue(solution.isPerfectSquare(num));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void test14Solution(Solution solution) {
    final int num = 14;
    assertFalse(solution.isPerfectSquare(num));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII()
    );
  }
}
