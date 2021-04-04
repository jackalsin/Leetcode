package lime._560_Subarray_Sum_Equals_K;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/3/2021
 */
class SolutionITest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] nums = {1, 1, 1};
    assertEquals(2, solution.subarraySum(nums, 2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] nums = {1, 1, 1};
    assertEquals(3, solution.subarraySum(nums, 1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[] nums = {1, 1, 1};
    assertEquals(1, solution.subarraySum(nums, 3));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int[] nums = {1, -1, 1, -1};
    assertEquals(4, solution.subarraySum(nums, 0));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}