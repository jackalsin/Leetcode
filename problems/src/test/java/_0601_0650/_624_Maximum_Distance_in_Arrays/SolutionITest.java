package _0601_0650._624_Maximum_Distance_in_Arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/5/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final List<List<Integer>> input = List.of(
        List.of(1, 2, 3),
        List.of(4, 5),
        List.of(1, 2, 3)
    );
    assertEquals(4, solution.maxDistance(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final List<List<Integer>> input = List.of(
        List.of(1),
        List.of(2)
    );
    assertEquals(1, solution.maxDistance(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final List<List<Integer>> input = List.of(
        List.of(1, 4, 5),
        List.of(0, 2)
    );
    assertEquals(5, solution.maxDistance(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new ONSpaceSolution(),
        new O1SpaceSolution()
    );
  }
}