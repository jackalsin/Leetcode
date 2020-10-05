package hulu._188_Best_Time_to_Buy_and_Sell_Stock_IV;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/11/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] input = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
    assertEquals(6, solution.maxProfit(2, input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testMultiTransMaxContinous(Solution solution) throws Exception {
    final int[] input = new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
    assertEquals(13, solution.maxProfit(2, input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test3TransMax(Solution solution) throws Exception {
    final int[] input = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
    assertEquals(6, solution.maxProfit(2, input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test2TransMax(Solution solution) throws Exception {
    final int[] input = new int[]{2, 4, 1};
    assertEquals(2, solution.maxProfit(2, input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}