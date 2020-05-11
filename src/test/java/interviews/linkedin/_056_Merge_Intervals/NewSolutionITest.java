package interviews.linkedin._056_Merge_Intervals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


/**
 * @author jacka
 * @version 1.0 on 6/27/2019
 */
class NewSolutionITest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithOnlineCase1(NewSolution solution) {
    final int[][] actual = solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15,
        18}});
    assertArrayEquals(new int[][]{{1, 6}, {8, 10}, {15, 18}}, actual);
  }

  static Stream<NewSolution> solutionStream() {
    return Stream.of(
        new NewSolutionI(),
        new NewSolutionII()
    );
  }


}