package _0051_0100._059_Spiral_Matrix_II;

import definition.TwoDimensionArray;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 4/22/2017.
 */
public class SolutionTest {

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

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
}