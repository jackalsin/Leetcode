package _0751_0800._775_Global_and_Local_Inversions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 8/30/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] A = {1, 0, 2};
    assertTrue(solution.isIdealPermutation(A));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] A = {1, 2, 0};
    assertFalse(solution.isIdealPermutation(A));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[] A = {2, 1, 0};
    assertFalse(solution.isIdealPermutation(A));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new NaiveSolution(),
        new ONSolution()
    );
  }
}