package google._1553_Minimum_Number_of_Days_to_Eat_N_Oranges;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/8/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase10(Solution solution) {
    assertEquals(4, solution.minDays(10));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase9(Solution solution) {
    assertEquals(3, solution.minDays(6));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new DpSolution()
    );
  }
}