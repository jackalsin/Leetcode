package interviews.oracle._167_Two_Sum_II_Input_array_is_sorted;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 11/4/2019
 */
class SolutionITest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    final int[] input = new int[]{2, 7, 11, 15};
    assertArrayEquals(new int[]{1, 2}, solution.twoSum(input, 9));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}