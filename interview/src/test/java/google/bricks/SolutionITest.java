package google.bricks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/30/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] bricks = {1, 2};
    final int w = 3;
    assertEquals(2, solution.numberOfWays(bricks, w, 3));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] bricks = {1, 2};
    final int w = 4;
    assertEquals(2, solution.numberOfWays(bricks, w, 2));
  }

  @Test
  void testCombination() {
    final int[] bricks = {1, 2, 3};
    final int w = 6;
    final List<Set<Integer>> actual = SolutionI.getCombination(bricks, w),
        expected = List.of(
            Set.of(1, 2, 3, 4, 5),
            Set.of(1, 2, 3, 4),
            Set.of(1, 2, 3, 5),
            Set.of(1, 2, 3),
            Set.of(1, 2, 4, 5),
            Set.of(1, 2, 4),
            Set.of(1, 2, 5),
            Set.of(1, 3, 4, 5),
            Set.of(1, 3, 4),
            Set.of(1, 3, 5),
            Set.of(1, 3),
            Set.of(1, 4, 5),
            Set.of(1, 4),
            Set.of(2, 3, 4, 5),
            Set.of(2, 3, 4),
            Set.of(2, 3, 5),
            Set.of(2, 3),
            Set.of(2, 4, 5),
            Set.of(2, 4),
            Set.of(2, 5),
            Set.of(3, 4, 5),
            Set.of(3, 4),
            Set.of(3, 5),
            Set.of(3)
        );
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}