package interviews.byteDance._079_Word_Search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author zhixi
 * @version 1.0 on 5/7/2020
 */
class SolutionITest {
  private char[][] getBoard() {
    return new char[][]{
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}
    };
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithOnlineCase(Solution solution) {
    assertTrue(solution.exist(getBoard(), "ASA"));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithOnlineCase2(Solution solution) {
    assertTrue(solution.exist(getBoard(), "ABC"));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithDupVisited(Solution solution) {
    assertFalse(solution.exist(getBoard(), "BFB"));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}