package facebook.practice.Element_Swapping;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 5/2/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    int n_1 = 3, k_1 = 2;
    int[] arr_1 = {5, 3, 1};
    int[] expected_1 = {1, 5, 3};
    int[] output_1 = solution.findMinArray(arr_1, k_1);
    assertArrayEquals(expected_1, output_1, Arrays.toString(output_1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    int n_2 = 5, k_2 = 3;
    int[] arr_2 = {8, 9, 11, 2, 1};
    int[] expected_2 = {2, 8, 9, 11, 1};
    int[] output_2 = solution.findMinArray(arr_2, k_2);
    assertArrayEquals(expected_2, output_2, Arrays.toString(output_2));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}