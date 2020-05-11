package interviews.oracle._554_Brick_Wall;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/20/2019
 */
class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionStream")
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
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final List<List<Integer>> input = List.of(
        List.of(1),
        List.of(1),
        List.of(1)
    );

    assertEquals(3, solution.leastBricks(input));
  }


  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}