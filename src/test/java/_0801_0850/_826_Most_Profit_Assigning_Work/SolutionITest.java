package _0801_0850._826_Most_Profit_Assigning_Work;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/1/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] difficulty = {2, 4, 6, 8, 10}, profit = {10, 20, 30, 40, 50}, worker = {4, 5, 6, 7};
    assertEquals(100, solution.maxProfitAssignment(difficulty, profit, worker));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] difficulty = {68, 35, 52, 47, 86}, profit = {67, 17, 1, 81, 3}, worker = {92, 10, 85, 84, 82};
    assertEquals(324, solution.maxProfitAssignment(difficulty, profit, worker));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}