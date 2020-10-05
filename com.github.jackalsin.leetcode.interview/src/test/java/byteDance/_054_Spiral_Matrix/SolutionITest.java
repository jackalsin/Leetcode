package byteDance._054_Spiral_Matrix;

import definition._054_Spiral_Matrix.Board;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhixi
 * @version 1.0 on 5/6/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWith3By3(Solution solution) {
    assertEquals(List.of(1, 2, 3, 6, 9, 8, 7, 4, 5), solution.spiralOrder(Board.get2dBoard(3, 3)));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWith5by5(Solution solution) {
    assertEquals(List.of(1, 2, 3, 4, 5, 10, 15, 20, 25, 24, 23, 22, 21, 16, 11, 6, 7, 8, 9, 14, 19, 18, 17, 12,
        13), solution.spiralOrder(Board.get2dBoard(5, 5)));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWith4by4(Solution solution) {
    assertEquals(List.of(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10),
        solution.spiralOrder(Board.get2dBoard(4, 4)));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWith1by2(Solution solution) {
    assertEquals(List.of(2, 3), solution.spiralOrder(new int[][]{{2, 3}}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWith3by1(Solution solution) {
    assertEquals(List.of(1, 2, 3), solution.spiralOrder(new int[][]{{1}, {2}, {3}}));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}