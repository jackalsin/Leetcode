package _0601_0650._629_K_Inverse_Pairs_Array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/9/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    // [1,2,3]
    final int n = 3, k = 0, expected = 1;
    assertEquals(expected, solution.kInversePairs(n, k));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    // [1, 3, 2], [2, 1, 3]
    final int n = 3, k = 1, expected = 2;
    assertEquals(expected, solution.kInversePairs(n, k));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    // [1, 2, 4, 3], [1, 3, 2, 4], [2, 1, 3, 4]
    final int n = 4, k = 1, expected = 3;
    assertEquals(expected, solution.kInversePairs(n, k));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final int n = 4, k = 2, expected = 5;
    assertEquals(expected, solution.kInversePairs(n, k));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new NaiveSolution(),
        new OptimizedSolution()
    );
  }
}