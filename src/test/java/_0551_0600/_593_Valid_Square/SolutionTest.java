package _0551_0600._593_Valid_Square;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/6/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[] p1 = {0, 0}, p2 = {1, 1}, p3 = {1, 0}, p4 = {0, 1};
    assertTrue(solution.validSquare(p1, p2, p3, p4));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[] p1 = {1, 0}, p2 = {-1, 0}, p3 = {0, 1}, p4 = {0, -1};
    assertTrue(solution.validSquare(p1, p2, p3, p4));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int[] p1 = {0, 0}, p2 = {-1, 0}, p3 = {1, 0}, p4 = {0, 1};
    assertFalse(solution.validSquare(p1, p2, p3, p4));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new DistanceSolution(),
        new SolutionII()
    );
  }
}