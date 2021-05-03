package facebook.practice.Balanced_Split;

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
    int arr_1[] = {2, 1, 2, 5};
    boolean expected_1 = true;
    boolean output_1 = solution.balancedSplitExists(arr_1);
    assertEquals(expected_1, output_1);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {

    int arr_2[] = {3, 6, 3, 4, 4};
    boolean expected_2 = false;
    boolean output_2 = solution.balancedSplitExists(arr_2);
    assertEquals(expected_2, output_2);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}