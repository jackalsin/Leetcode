package _0151_0200._200_Number_of_Islands;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.TwoDimensionArray.getCharBoard;

/**
 * @author jacka
 * @version 1.0 on 8/5/2017.
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
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
  @MethodSource("solutionProvider")
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
  @MethodSource("solutionProvider")
  void testEmpty(Solution solution) {
    final char[][] grid = new char[][]{{}};
    assertEquals(0, solution.numIslands(grid));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}
