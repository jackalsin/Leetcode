package hulu._059_Spiral_Matrix_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.TwoDimensionArray;

import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2/23/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWith1(Solution solution) {
    int[][] expected = {{1}};
    assertTrue(TwoDimensionArray.TwoDimensionArrayEquals(expected, solution.generateMatrix(1)));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWith2(Solution solution) {
    int[][] expected = {{1, 2}, {4, 3}};
    assertTrue(TwoDimensionArray.TwoDimensionArrayEquals(expected, solution.generateMatrix(2)));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWith3(Solution solution) {
    int[][] expected = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
    assertTrue(TwoDimensionArray.TwoDimensionArrayEquals(expected, solution.generateMatrix(3)));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}