package interviews.google._363_Max_Sum_of_Rectangle_No_Larger_Than_K;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/6/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testOnlineCase1(Solution solution) throws Exception {
    final int[][] matrix = new int[][]{
        {1, 0, 1},
        {0, -2, 3}
    };
    assertEquals(2, solution.maxSumSubmatrix(matrix, 2));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testOnlineCase2(Solution solution) throws Exception {
    final int[][] matrix = new int[][]{
        {2, 2, -1}
    };
    assertEquals(3, solution.maxSumSubmatrix(matrix, 3));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testOnlineCase3(Solution solution) throws Exception {
    final int[][] matrix = new int[][]{
        {2, 2, -1}
    };
    assertEquals(-1, solution.maxSumSubmatrix(matrix, 0));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testOnlineCase4(Solution solution) throws Exception {
    final int[][] matrix = new int[][]{
        {5, -4, -3, 4},
        {-3, -4, 4, 5},
        {5, 1, 5, -4}
    };
    assertEquals(10, solution.maxSumSubmatrix(matrix, 10));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}