package _1351_1400._1389_Create_Target_Array_in_the_Given_Order;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 3/21/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[] nums = {0, 1, 2, 3, 4}, index = {0, 1, 2, 2, 1},
        expected = {0, 4, 1, 3, 2}, actual = solution.createTargetArray(nums, index);
    assertArrayEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[] nums = {1, 2, 3, 4, 0}, index = {0, 1, 2, 3, 0},
        expected = {0, 1, 2, 3, 4}, actual = solution.createTargetArray(nums, index);
    assertArrayEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}