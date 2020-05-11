package interviews.linkedin._238_Product_of_Array_Except_Self;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    final int[] input = {1, 2, 3, 4};
    final int[] expected = {24, 12, 8, 6};
    assertArrayEquals(expected, solution.productExceptSelf(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] input = {9, 0, -2};
    final int[] expected = {0, -18, 0};
    assertArrayEquals(expected, solution.productExceptSelf(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new SolutionIV()
    );
  }
}
