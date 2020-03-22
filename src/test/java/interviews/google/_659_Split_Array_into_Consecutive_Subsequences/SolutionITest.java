package interviews.google._659_Split_Array_into_Consecutive_Subsequences;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 3/22/2020
 */
class SolutionITest {
  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testOnlineCase1(Solution solution) {
    final int[] nums = {1, 2, 3, 4, 5, 6};
    assertTrue(solution.isPossible(nums));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testOnlineCase2(Solution solution) {
    final int[] nums = {1, 2, 3, 3, 4, 4, 5, 5};
    assertTrue(solution.isPossible(nums));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testOnlineCase3(Solution solution) {
    final int[] nums = {1, 2, 3, 4, 4, 5};
    assertFalse(solution.isPossible(nums));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testFailedCase1(Solution solution) {
    final int[] nums = {1, 2, 3, 3, 4, 5};
    assertTrue(solution.isPossible(nums));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}