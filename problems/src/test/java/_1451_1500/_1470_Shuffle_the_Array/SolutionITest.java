package _1451_1500._1470_Shuffle_the_Array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 2/28/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int nums[] = {2, 5, 1, 3, 4, 7}, n = 3,
        actual[] = solution.shuffle(nums, n),
        expected[] = {2, 3, 5, 4, 1, 7};
    assertArrayEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int nums[] = {1, 2, 3, 4, 4, 3, 2, 1}, n = 4,
        actual[] = solution.shuffle(nums, n),
        expected[] = {1, 4, 2, 3, 3, 2, 4, 1};
    assertArrayEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int nums[] = {1, 1, 2, 2}, n = 2,
        actual[] = solution.shuffle(nums, n),
        expected[] = {1, 2, 1, 2};
    assertArrayEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}