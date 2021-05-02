package facebook.Seating_Arrangements;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/2/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    int[] arr_1 = {5, 10, 6, 8};
    int expected_1 = 4;
    int output_1 = solution.minOverallAwkwardness(arr_1);
    assertEquals(expected_1, output_1);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    int[] arr_2 = {1, 2, 5, 3, 7};
    int expected_2 = 4;
    int output_2 = solution.minOverallAwkwardness(arr_2);
    assertEquals(expected_2, output_2);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}