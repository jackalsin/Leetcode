package interviews.newsbreak._286_Walls_and_Gates;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 9/29/2020
 */
class SolutionITest {
  private static final int INF = Integer.MAX_VALUE;

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnline(Solution solution) {
    final int[][] input = {
        {INF, -1, 0, INF},
        {INF, INF, INF, -1},
        {INF, -1, INF, -1},
        {0, -1, INF, INF}
    };

    final int[][] expected = {{3, -1, 0, 1},
        {2, 2, 1, -1},
        {1, -1, 2, -1},
        {0, -1, 3, 4}};
    solution.wallsAndGates(input);
    assertTrue(Arrays.deepEquals(expected, input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}