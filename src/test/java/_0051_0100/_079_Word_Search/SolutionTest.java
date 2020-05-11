package _0051_0100._079_Word_Search;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 5/13/2017.
 */
class SolutionTest {
  private static final char[][] BOARD = new char[][]{
      {'A', 'B', 'C', 'E'},
      {'S', 'F', 'C', 'S'},
      {'A', 'D', 'E', 'E'}
  };

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithOnlineCase(Solution solution) {
    assertTrue(solution.exist(BOARD, "ASA"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithOnlineCase2(Solution solution) {
    assertTrue(solution.exist(BOARD, "ABC"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithDupVisited(Solution solution) {
    assertFalse(solution.exist(BOARD, "BFB"));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }
}