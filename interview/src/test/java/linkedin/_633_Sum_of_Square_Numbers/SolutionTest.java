package linkedin._633_Sum_of_Square_Numbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 8/15/2019
 */
class SolutionTest {


  @ParameterizedTest
  @MethodSource("solutionStream")
  void test25(Solution solution) {
    assertTrue(solution.judgeSquareSum(25));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    final int input = 5;
    assertTrue(solution.judgeSquareSum(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int input = 3;
    assertFalse(solution.judgeSquareSum(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SetSolution(),
        new TwoPointerSolution(),
        new TwoPointerSolutionI()
    );
  }
}