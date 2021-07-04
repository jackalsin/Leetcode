package _1901_1950._1920_Build_Array_from_Permutation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 7/3/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] nums = {0, 2, 1, 5, 3, 4}, expected = {0, 1, 2, 4, 5, 3},
        actual = solution.buildArray(nums);
    assertArrayEquals(expected, actual);
  }
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] nums = {5,0,1,2,3,4}, expected = {4,5,0,1,2,3},
        actual = solution.buildArray(nums);
    assertArrayEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}