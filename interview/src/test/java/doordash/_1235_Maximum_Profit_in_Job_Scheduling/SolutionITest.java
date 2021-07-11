package doordash._1235_Maximum_Profit_in_Job_Scheduling;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/10/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] startTime = {1, 2, 3, 3}, endTime = {3, 4, 5, 6}, profit = {50, 10, 40, 70};
    assertEquals(120, solution.jobScheduling(startTime, endTime, profit));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] startTime = {1, 2, 3, 4, 6}, endTime = {3, 5, 10, 6, 9}, profit = {20, 20, 100, 70, 60};
    assertEquals(150, solution.jobScheduling(startTime, endTime, profit));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[] startTime = {1, 1, 1}, endTime = {2, 3, 4}, profit = {5, 6, 4};
    assertEquals(6, solution.jobScheduling(startTime, endTime, profit));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}