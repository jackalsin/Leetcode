package _0551_0600._554_Brick_Wall;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final List<List<Integer>> input = List.of(
        List.of(1, 2, 2, 1),
        List.of(3, 1, 2),
        List.of(1, 3, 2),
        List.of(2, 4),
        List.of(3, 1, 2),
        List.of(1, 3, 1, 1)
    );

    assertEquals(2, solution.leastBricks(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final List<List<Integer>> input = List.of(
        List.of(1),
        List.of(1),
        List.of(1)
    );

    assertEquals(3, solution.leastBricks(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII()
    );
  }

}