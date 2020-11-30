package _1051_1100._1072_Flip_Columns_For_Maximum_Number_of_Equal_Rows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhixi
 * @version 1.0 on 11/29/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[][] input = {
        {0, 1},
        {1, 1}
    };
    assertEquals(1, solution.maxEqualRowsAfterFlips(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[][] input = {
        {0, 1},
        {1, 0}
    };
    assertEquals(2, solution.maxEqualRowsAfterFlips(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int[][] input = {
        {0, 0, 0,},
        {0, 0, 1,},
        {1, 1, 0,}
    };
    assertEquals(2, solution.maxEqualRowsAfterFlips(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}