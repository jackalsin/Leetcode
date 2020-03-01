package _0551_0600._576_Out_of_Boundary_Paths;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/1/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int m = 2, n = 2, N = 2, i = 0, j = 0, expected = 6;
    assertEquals(expected, solution.findPaths(m, n, N, i, j));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int m = 1, n = 3, N = 3, i = 0, j = 1, expected = 12;
    assertEquals(expected, solution.findPaths(m, n, N, i, j));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}