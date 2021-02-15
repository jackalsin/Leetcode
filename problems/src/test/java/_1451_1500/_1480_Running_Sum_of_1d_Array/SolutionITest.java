package _1451_1500._1480_Running_Sum_of_1d_Array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author zhixi
 * @version 1.0 on 2/9/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[] nums = {1, 2, 3, 4}, expects = {1, 3, 6, 10};
    assertArrayEquals(expects, solution.runningSum(nums));
  }


  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[] nums = {1, 1, 1, 1, 1}, expects = {1, 2, 3, 4, 5};
    assertArrayEquals(expects, solution.runningSum(nums));
  }


  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int[] nums = {3, 1, 2, 10, 1}, expects = {3, 4, 6, 16, 17};
    assertArrayEquals(expects, solution.runningSum(nums));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}