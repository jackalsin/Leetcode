package google.mazeTravelLess;

import google.mazeTravelLess.minCost.Solution;
import google.mazeTravelLess.minCost.SolutionI;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/7/2021
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] input = {
        {6, 4, 7, 2},
        {3, 6, 7, 5}
    };
    assertEquals(3, solution.minCost(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}