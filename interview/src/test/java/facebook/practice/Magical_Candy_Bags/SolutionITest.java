package facebook.practice.Magical_Candy_Bags;

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
    int n_1 = 5, k_1 = 3;
    int[] arr_1 = {2, 1, 7, 4, 2};
    int expected_1 = 14;
    int output_1 = solution.maxCandies(arr_1, k_1);
    assertEquals(expected_1, output_1);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    int n_2 = 9, k_2 = 3;
    int[] arr_2 = {19, 78, 76, 72, 48, 8, 24, 74, 29};
    int expected_2 = 228;
    int output_2 = solution.maxCandies(arr_2, k_2);
    assertEquals(expected_2, output_2);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}