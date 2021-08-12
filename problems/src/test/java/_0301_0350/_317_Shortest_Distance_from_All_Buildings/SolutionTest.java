package _0301_0350._317_Shortest_Distance_from_All_Buildings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/22/2017.
 */
public class SolutionTest {
  private static final int[][] NORMAL_BOARD = {
      {1, 0, 2, 0, 1},
      {0, 0, 0, 0, 0},
      {0, 0, 1, 0, 0}
  };

  private static final int[][] FULL_BUILDING_BOARD_1_BY_1 = {{1}};

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testNormalCase(Solution solution) {
    assertEquals(7, solution.shortestDistance(NORMAL_BOARD));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFullBuildingBoard1By1(Solution solution) {
    assertEquals(-1, solution.shortestDistance(FULL_BUILDING_BOARD_1_BY_1));
  }
}
