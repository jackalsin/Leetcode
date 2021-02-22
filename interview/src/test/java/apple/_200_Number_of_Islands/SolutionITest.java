package apple._200_Number_of_Islands;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static definition.TwoDimensionArray.getCharBoard;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/22/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testExample1(Solution solution) {
    final char[][] grid = getCharBoard(new String[]{
        "11110",
        "11010",
        "11000",
        "00000"
    });
    assertEquals(1, solution.numIslands(grid));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testExample2(Solution solution) {
    final char[][] grid = getCharBoard(new String[]{
        "11000",
        "11000",
        "00100",
        "00011"
    });
    assertEquals(3, solution.numIslands(grid));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmpty(Solution solution) {
    final char[][] grid = new char[][]{{}};
    assertEquals(0, solution.numIslands(grid));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}