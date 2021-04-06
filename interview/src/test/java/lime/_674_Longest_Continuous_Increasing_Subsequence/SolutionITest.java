package lime._674_Longest_Continuous_Increasing_Subsequence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/6/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] nums = {1, 3, 5, 4, 7};
    assertEquals(3, solution.findLengthOfLCIS(nums));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] nums = {2, 2, 2, 2, 2};
    assertEquals(1, solution.findLengthOfLCIS(nums));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}