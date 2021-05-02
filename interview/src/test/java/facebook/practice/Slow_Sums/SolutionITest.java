package facebook.practice.Slow_Sums;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/1/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    int[] arr_1 = {4, 2, 1, 3};
    int expected_1 = 26;
    int output_1 = solution.getTotalTime(arr_1);
    assertEquals(expected_1, output_1);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    int[] arr_2 = {2, 3, 9, 8, 4};
    int expected_2 = 88;
    int output_2 = solution.getTotalTime(arr_2);
    assertEquals(expected_2, output_2);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}