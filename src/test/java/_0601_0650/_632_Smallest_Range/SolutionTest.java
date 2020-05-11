package _0601_0650._632_Smallest_Range;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final List<List<Integer>> input = List.of(
        List.of(4, 10, 15, 24, 26),
        List.of(0, 9, 12, 20),
        List.of(5, 18, 22, 30)
    );
    final int[] actual = solution.smallestRange(input),
        expected = {20, 24};
    assertArrayEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final List<List<Integer>> input = List.of(
        List.of(24, 39),
        List.of(24, 30),
        List.of(1)
    );
    final int[] actual = solution.smallestRange(input),
        expected = {1, 24};
    assertArrayEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SinglePriorityQueueSolution(),
        new BestSolution()
    );
  }
}