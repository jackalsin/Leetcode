package apple._079_Word_Search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2/21/2021
 */
class SolutionITest {
  private char[][] board;

  @BeforeEach
  void setup() {
    board = new char[][]{
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}
    };
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithOnlineCase(Solution solution) {
    assertTrue(solution.exist(board, "ASA"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithOnlineCase2(Solution solution) {
    assertTrue(solution.exist(board, "ABC"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithDupVisited(Solution solution) {
    assertFalse(solution.exist(board, "BFB"));
  }


  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}