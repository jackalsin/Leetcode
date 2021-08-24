package airbnb._220_Contains_Duplicate_III;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 1/27/2019.
 */
class SolutionTest {

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new TreeSetSolution(),
        new BucketSortSolution(),
        new TreeSetSolutionI(),
        new BucketSortSolutionI()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testPositive(Solution solution) {
    final int[] input = new int[]{1, 5, 66, 5, 3};
    assertTrue(solution.containsNearbyAlmostDuplicate(input, 2, 2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testNegativeT(Solution solution) {
    final int[] input = new int[]{1, 5, 1, 66, 5, 3};
    assertTrue(solution.containsNearbyAlmostDuplicate(input, 1, 65));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testNegativeK(Solution solution) {
    final int[] input = new int[]{1, 10000, 66};
    assertFalse(solution.containsNearbyAlmostDuplicate(input, 1, 65));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test1And1(Solution solution) {
    final int[] input = new int[]{1};
    assertFalse(solution.containsNearbyAlmostDuplicate(input, 1, 1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test1And3And1(Solution solution) {
    final int[] input = new int[]{1, 3, 1};
    assertTrue(solution.containsNearbyAlmostDuplicate(input, 2, 1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testK0(Solution solution) {
    final int[] input = new int[]{1, 2};
    assertFalse(solution.containsNearbyAlmostDuplicate(input, 0, 1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOverflow(Solution solution) {
    final int a = 2147483647;
    final int[] input = new int[]{0, a};
    assertTrue(solution.containsNearbyAlmostDuplicate(input, 1, a));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testT0(Solution solution) {
    final int[] input = new int[]{-1, -1};
    assertTrue(solution.containsNearbyAlmostDuplicate(input, 1, 0));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailed(Solution solution) {
    final int[] input = new int[]{2, 1};
    assertTrue(solution.containsNearbyAlmostDuplicate(input, 1, 1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailed2(Solution solution) {
    final int[] input = new int[]{-1, 2147483647};
    assertFalse(solution.containsNearbyAlmostDuplicate(input, 1, 2147483647));
  }

}