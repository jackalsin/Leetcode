package _0151_0200._167_Two_Sum_II_Input_array_is_sorted;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase(Solution solution) {
    final int[] input = new int[]{2, 7, 11, 15};
    assertArrayEquals(new int[]{1, 2}, solution.twoSum(input, 9));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new Solution()
    );
  }
}