package oracle._123_Best_Time_to_Buy_and_Sell_Stock_III;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/10/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmpty(Solution solution) {
    assertEquals(0, solution.maxProfit(new int[]{}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test2TransMax(Solution solution) {
    final int[] input = new int[]{1, 5, 0, 1, 5};
    assertEquals(9, solution.maxProfit(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test1TransMax(Solution solution) {
    final int[] input = new int[]{1, 2, 3, 4, 5};
    assertEquals(4, solution.maxProfit(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testMultiMaxLater(Solution solution) {
    final int[] input = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
    assertEquals(6, solution.maxProfit(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testMultiTransMaxContinuous(Solution solution) {
    final int[] input = new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
    assertEquals(13, solution.maxProfit(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test3TransMax(Solution solution) {
    final int[] input = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
    assertEquals(6, solution.maxProfit(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}