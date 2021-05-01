package facebook.practice.Largest_Triple_Products;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 5/1/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    int[] arr_1 = {1, 2, 3, 4, 5};
    int[] expected_1 = {-1, -1, 6, 24, 60};
    int[] output_1 = solution.findMaxProduct(arr_1);
    assertArrayEquals(expected_1, output_1, Arrays.toString(output_1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    int[] arr_2 = {2, 4, 7, 1, 5, 3};
    int[] expected_2 = {-1, -1, 56, 56, 140, 140};
    int[] output_2 = solution.findMaxProduct(arr_2);
    assertArrayEquals(expected_2, output_2, Arrays.toString(output_2));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}