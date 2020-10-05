package _0901_0950._915_Partition_Array_into_Disjoint_Intervals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/19/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int input[] = {5, 0, 3, 8, 6}, expected = 3, actual = solution.partitionDisjoint(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int input[] = {1, 1, 1, 0, 6, 12},
        expected = 4, actual = solution.partitionDisjoint(input);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SpaceONSolution(),
        new SpaceO1Solution()
    );
  }
}